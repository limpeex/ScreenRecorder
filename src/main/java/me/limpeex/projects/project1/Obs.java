package me.limpeex.projects.project1;

import java.util.ArrayList;
import java.util.Scanner;


public class Obs extends ScreenRecorder {
    static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Records> records = new ArrayList<>();
    private static String directory = "C:/Videos/";
    private static int x;
    private long fps = 60;
    private String res = "1280x720";

    public static void main(String[] a) throws InterruptedException {
        mainTable();
    }

    public static void mainTable() throws InterruptedException {
        Obs obs = new Obs();
        System.out.println("Welcome to your program: ");
        System.out.println("Press 1: Start Recording...");
        System.out.println("Press 2: Start Streaming...");
        System.out.println("Press 3: Go Settings...");
        System.out.println("Press 4: Quit...");
        int method = scanner.nextInt();

        if (method == 1) {
            obs.startRecord();
            long time1 = System.currentTimeMillis();
            scanner.nextLine();
            String recordEndButton = scanner.nextLine();
            if (recordEndButton.equalsIgnoreCase("3")) {
                long time2 = System.currentTimeMillis();
                long timeForAll = time2 - time1;
                directory = directory + x + "";
                records.add(recordRegister(timeForAll, directory));
                System.out.println("Video took " + timeForAll / 1000 + " seconds...");
                System.out.println("Directory Location: " + directory);
                x++;
                Thread.sleep(2500);
                mainTable();
            } else {
                System.out.println("UNVALID METHOD");
                obs.stopRecord();
                mainTable();
            }
        } else if (method == 2) {
            obs.startStream();
            scanner.nextLine();
            String recordButton = scanner.nextLine();
            if (recordButton.equals("3")) {
                obs.stopStream();
                Thread.sleep(2500);
                mainTable();
            }
        } else if (method == 3) {
            obs.getSettings();
        } else if (method == 4) {
            while (true) {
                break;
            }
        } else {
            System.out.println("UNVALID METHOD");
            Thread.sleep(2500);
            mainTable();
        }
    }

    public static ArrayList<Records> getRecords() {
        return records;
    }

    public static void setRecords(ArrayList<Records> records) {
        Obs.records = records;
    }

    public static Records recordRegister(long recordLong, String recordName) {
        Records newRecord = new Records();
        newRecord.setRecordLong(recordLong / 1000);
        newRecord.setRecordName(recordName);
        return newRecord;
    }

    @Override
    public void startRecord() {
        System.out.println("Your Record Just Started, Press 3 If You Want To Stop Record...");
    }

    @Override
    public void stopRecord() {
        System.out.println("Your Record Has Stopped");
    }

    @Override
    public void startStream() {
        System.out.println("Your Stream Has Started, Press 3 If You Want To Stop Streaming");
    }

    @Override
    public void stopStream() {
        System.out.println("Your stream has stopped");
    }

    @Override
    public void getSettings() throws InterruptedException {
        System.out.println("You Went Through Settings... Choose something");
        System.out.println("Press 1: Change Resolution");
        System.out.println("Press 2: Change FPS");
        System.out.println("Press 3: See record settings...");
        System.out.println("Press 4: Go through records..");
        System.out.println("Press 5: Quit");
        int x = scanner.nextInt();

        switch (x) {
            case 1:
                System.out.println("Press 1: Custom Resolution");
                System.out.println("Press 2: Default Resolution");
                scanner.nextLine();
                int choose = scanner.nextInt();

                if (choose == 1) {
                    System.out.println("Resolution you want to set: ");
                    scanner.nextLine();
                    String customRes = scanner.nextLine();
                    char[] chars = customRes.toCharArray();
                    for (int i = 0; i < chars.length; i++) {
                        if (customRes.length() == 9) {
                            if (Character.isDigit(customRes.charAt(0)) && Character.isDigit(customRes.charAt(1)) && Character.isDigit(customRes.charAt(2)) && Character.isDigit(customRes.charAt(3))) {
                                if (customRes.charAt(4) == 'x') {
                                    if (Character.isDigit(customRes.charAt(5)) && Character.isDigit(customRes.charAt(6)) && Character.isDigit(customRes.charAt(7)) && Character.isDigit(customRes.charAt(8))) {
                                        setRes(customRes);
                                        System.out.println("Resolution setted: " + customRes);
                                        Thread.sleep(2500);
                                        getSettings();
                                    }
                                }
                            }
                            getSettings();
                        } else if (customRes.length() == 8) {
                            if (Character.isDigit(customRes.charAt(0)) && Character.isDigit(customRes.charAt(1)) && Character.isDigit(customRes.charAt(2)) && Character.isDigit(customRes.charAt(3))) {
                                if (customRes.charAt(4) == 'x') {
                                    if (Character.isDigit(customRes.charAt(5)) && Character.isDigit(customRes.charAt(6)) && Character.isDigit(customRes.charAt(7))) {
                                        setRes(customRes);
                                        System.out.println("Resolution setted: " + customRes);
                                        Thread.sleep(2500);
                                        getSettings();
                                    }
                                }
                            }
                            getSettings();
                        } else if (customRes.length() == 7) {
                            if (Character.isDigit(customRes.charAt(0)) && Character.isDigit(customRes.charAt(1)) && Character.isDigit(customRes.charAt(2))) {
                                if (customRes.charAt(3) == 'x') {
                                    if (Character.isDigit(customRes.charAt(4)) && Character.isDigit(customRes.charAt(5)) && Character.isDigit(customRes.charAt(6))) {
                                        setRes(customRes);
                                        System.out.println("Resolution setted: " + customRes);
                                        Thread.sleep(2500);
                                        getSettings();
                                    }
                                }
                            }
                            getSettings();
                        } else {
                            System.out.println("INVALID");
                            Thread.sleep(2500);
                            getSettings();
                        }
                        System.out.println("INVALID");
                        getSettings();
                    }
                } else if (choose == 2) {
                    System.out.println("Available Resoulutions");
                    System.out.println("***********************");
                    System.out.println("Press 1: 1920x1080");
                    System.out.println("Press 2: 1680x1050");
                    System.out.println("Press 3: 1600x900");
                    System.out.println("Press 4: 1440x900");
                    System.out.println("Press 5: 1366x768");
                    System.out.println("Press 6: 1280x1024");
                    System.out.println("Press 7: 1280x720");
                    System.out.println("Press 8: 800x600");
                    System.out.println("***********************");

                    System.out.println("Choose resolution: ");
                    scanner.nextLine();
                    String answer = scanner.nextLine();
                    setRes(answer);
                    System.out.println("Resouliton setted: " + getRes());
                    Thread.sleep(2000);
                    getSettings();
                } else {

                }
            case 2:
                System.out.println("Text your fps(30, 60, 90, 120): ");
                scanner.nextLine();
                int fpsValue = scanner.nextInt();
                setFps(fpsValue);
                Thread.sleep(2000);
                getSettings();
            case 3:
                System.out.println("**Here is your record settings**");
                System.out.println("Resolution: " + getRes());
                System.out.println("FPS: " + getFps());
                Thread.sleep(2500);
                getSettings();
            case 4:

                if (!(records.isEmpty())) {
                    for (Records record : records) {
                        System.out.println("[" + record.getRecordName() + " , " + record.getRecordLong() + "]");
                    }
                    Thread.sleep(2500);
                    getSettings();
                } else {
                    System.out.println("No records...");
                    Thread.sleep(2500);
                    getSettings();
                }
            case 5:
                mainTable();
            default:
                System.out.println("UNVALID METHOD");
                Thread.sleep(2500);
                getSettings();

        }
    }

    public long getFps() {
        return fps;
    }

    public void setFps(long fps) throws InterruptedException {
        if (fps != 30 && fps != 60 && fps != 90 && fps != 120) {
            System.out.println("FPS only can be 30, 60 ,90 and 120...");
            Thread.sleep(2500);
            mainTable();
        } else {
            System.out.println("FPS has been setted: " + fps);
            this.fps = fps;
        }
    }

    public String getRes() {
        return res;
    }

    public void setRes(String index) {
        if (index.equalsIgnoreCase("1")) {
            index = "1920x1080";
        } else if (index.equalsIgnoreCase("2")) {
            index = "1650x1050";
        } else if (index.equalsIgnoreCase("3")) {
            index = "1600x900";
        } else if (index.equalsIgnoreCase("4")) {
            index = "1440x900";
        } else if (index.equalsIgnoreCase("5")) {
            index = "1366x768";
        } else if (index.equalsIgnoreCase("6")) {
            index = "1280x1024";
        } else if (index.equalsIgnoreCase("7")) {
            index = "1280x720";
        } else if (index.equalsIgnoreCase("8")) {
            index = "800x600";
        }
        this.res = index;
    }
}
