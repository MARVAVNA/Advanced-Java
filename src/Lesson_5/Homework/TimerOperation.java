package Lesson_5.Homework;

import Lesson_5.Homework.view.TimerForm;

import javax.swing.*;

public class TimerOperation extends Thread {
    private byte minutes;
    private byte seconds;
    private final TimerForm timerForm;

    public TimerOperation(byte minutes, byte seconds, TimerForm timerForm) {
        this.minutes = minutes;
        this.seconds = seconds;
        this.timerForm = timerForm;
    }

    @Override
    public void run() {
        int allSeconds = 60 * minutes + seconds;

        if (allSeconds > 0) {
            JTextField timerMinute = new JTextField();
            JTextField timerSecond = new JTextField();
            timerMinute.setText(String.valueOf(minutes));
            timerSecond.setText(String.valueOf(seconds));

            timerForm.setCurrentTimeTimer(timerMinute, timerSecond);
            boolean isEnabled = true;
            for (int i = allSeconds; i > 0; i--) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {
                    isEnabled = false;
                    break;
                }
                if (i % 60 == 0) {
                    seconds = 59;
                    minutes--;
                } else {
                    seconds--;
                }

                timerMinute.setText(String.valueOf(minutes));
                timerSecond.setText(String.valueOf(seconds));

                timerForm.setCurrentTimeTimer(timerMinute, timerSecond);
            }

            if (isEnabled) {
                timerForm.enableTimerControls();
                Media.play();
            }
        }
    }
}
