package Lesson_5.Homework.view;

import Lesson_5.Homework.Media;
import Lesson_5.Homework.TimerOperation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TimerForm extends JFrame {
    private TimerOperation timer;
    private JPanel timerPanel;
    private JLabel timerMainTimeLabel;
    private JLabel timerCurrentTimeLabel;
    private JLabel minuteLabel;
    private JLabel secondLabel;
    private JTextField timerMinute;
    private JTextField timerSecond;
    private JButton startButton;
    private JButton resetButton;

    public static void init() {
        TimerForm timerForm = new TimerForm();
        timerForm.initForm();
        timerForm.initEvent();
    }

    private void initEvent() {
        timerMinute.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                inputNumber(e, timerMinute);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                setMainTimeTimer(timerMinute, timerSecond);
            }
        });

        timerSecond.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                inputNumber(e, timerSecond);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                setMainTimeTimer(timerMinute, timerSecond);
            }
        });

        startButton.addActionListener((actionListener) -> startTimer());
        resetButton.addActionListener((actionListener) -> resetTimer());
    }

    private void resetTimer() {
        timer.interrupt();
        enableTimerControls();
        setCurrentTimeTimer(new JTextField(), new JTextField());
        setMainTimeTimer(new JTextField(), new JTextField());
        timerSecond.setText("");
        timerMinute.setText("");
        resetButton.setEnabled(false);
    }

    private void initForm() {
        timerPanel = new JPanel();
        timerPanel.setLayout(new GridBagLayout());
        minuteLabel = new JLabel("Minute");
        timerCurrentTimeLabel = new JLabel("00 : 00");
        timerCurrentTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timerCurrentTimeLabel.setFont(new Font("Default", Font.PLAIN, 40));
        timerMainTimeLabel = new JLabel("00 : 00");
        timerMainTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timerMainTimeLabel.setFont(new Font("Default", Font.PLAIN, 40));
        startButton = new JButton("Start");
        resetButton = new JButton("Reset");
        resetButton.setEnabled(false);
        timerMinute = new JTextField();
        Dimension dtm = new Dimension();
        dtm.setSize(100, 25);
        timerMinute.setPreferredSize(dtm);
        secondLabel = new JLabel("Second");
        timerSecond = new JTextField();
        timerSecond.setPreferredSize(dtm);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        timerPanel.add(timerMainTimeLabel, gbc);

        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        timerPanel.add(spacer1, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        timerPanel.add(timerCurrentTimeLabel, gbc);

        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        timerPanel.add(spacer2, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        timerPanel.add(minuteLabel, gbc);

        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        timerPanel.add(spacer3, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 4;
        timerPanel.add(timerMinute, gbc);

        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.VERTICAL;

        timerPanel.add(spacer4, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        timerPanel.add(secondLabel, gbc);

        final JPanel spacer5 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 6;
        timerPanel.add(spacer5, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 6;
        timerPanel.add(timerSecond, gbc);

        final JPanel spacer6 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.VERTICAL;
        timerPanel.add(spacer6, gbc);

        gbc = new GridBagConstraints();
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.gridx = 0;
        gbc.gridy = 8;
        timerPanel.add(startButton, gbc);

        final JPanel spacer7 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        timerPanel.add(spacer7, gbc);

        gbc = new GridBagConstraints();
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.gridx = 2;
        gbc.gridy = 8;
        timerPanel.add(resetButton, gbc);

        setSize(300, 300);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        add(timerPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void inputNumber(KeyEvent e, JTextField inputField) {
        char ch = e.getKeyChar();

        if (!Character.isDigit(ch))  {
            e.consume();
            return;
        }

        if (ch == '\b' || ch == '\u007F') {
            return;
        }

        if (inputField.getText().equals("00")) {
            inputField.setText("0");
            return;
        }

        final String FINAL_TIMER_TEXT = inputField.getText().trim().equals("0") ? "" : inputField.getText().trim();
        String timerText = inputField.getText().trim();

        String selectedText = inputField.getSelectedText();
        boolean selected = false;
        if (selectedText != null) {
            selected = true;
            int selectedTextStartIndex = inputField.getSelectionStart();
            StringBuilder sb = new StringBuilder()
                    .append(timerText, 0, selectedTextStartIndex)
                    .append(ch)
                    .append(timerText.substring(inputField.getSelectionEnd()));
            inputField.setText(sb.toString());
            inputField.setCaretPosition(selectedTextStartIndex + 1);
            e.consume();
        }

        timerText = inputField.getText().equals("") ? String.valueOf(ch) : inputField.getText();
        short timerCastToShort = Short.parseShort(timerText + (
                (!inputField.getText().equals("") && !selected) ? ch : ""
            )
        );
        byte timerTextLength = (byte) String.valueOf(timerCastToShort).length();
        boolean check = !timerText.equals("") &&
                ((timerTextLength >= 2 && timerCastToShort > 59) ||
                        (!FINAL_TIMER_TEXT.isEmpty() && !selected && timerTextLength == 1 && timerCastToShort > 5));

        if (check) {
            inputField.setText("59");
            e.consume();
        }
    }

    private void setMainTimeTimer(JTextField timerMinute, JTextField timerSecond) {
        timerMainTimeLabel.setText(new StringBuilder(considerTimerTime(timerMinute))
                .append(" : ")
                .append(considerTimerTime(timerSecond))
                .toString()
        );
    }

    public void setCurrentTimeTimer(JTextField timerMinute, JTextField timerSecond) {
        timerCurrentTimeLabel.setText(new StringBuilder(considerTimerTime(timerMinute))
                .append(" : ")
                .append(considerTimerTime(timerSecond))
                .toString()
        );
    }

    private String considerTimerTime(JTextField textField) {
        String text = textField.getText();
        text = text.length() == 1 ? "0" + text : text;
        return text.equals("") ? "00" : text;
    }

    private void startTimer() {
        byte minute = Byte.parseByte(timerMinute.getText().isEmpty() ? "0" : timerMinute.getText());
        byte second = Byte.parseByte(timerSecond.getText().isEmpty() ? "0" : timerSecond.getText());
        if (minute == 0 && second == 0) {
            JOptionPane.showMessageDialog(null, "You have not specified the minutes and seconds of the timer");
            return;
        }

        if (Media.getClip() != null && Media.getClip().isRunning()) {
            Media.stop();
        }

        timer = new TimerOperation(minute, second, this);
        timer.start();

        disableTimerControls();
    }

    public void disableTimerControls() {
        timerMinute.setEnabled(false);
        timerSecond.setEnabled(false);
        startButton.setEnabled(false);
        resetButton.setEnabled(true);
    }

    public void enableTimerControls() {
        timerMinute.setEnabled(true);
        timerSecond.setEnabled(true);
        startButton.setEnabled(true);
        resetButton.setEnabled(false);
    }
}
