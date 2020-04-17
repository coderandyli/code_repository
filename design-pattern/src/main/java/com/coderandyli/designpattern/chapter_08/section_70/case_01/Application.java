package com.coderandyli.designpattern.chapter_08.section_70.case_01;

import java.util.Scanner;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/4/16 下午6:23
 */
public class Application {
    public static void main(String[] args) {
        InputText inputText = new InputText();
        SnapshotHolder snapshotHolder = new SnapshotHolder();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String input = scanner.next();
            if (input.equals(":list")){
                System.out.println(inputText.getText());
            } else if (input.equals(":undo")) {
                Snapshot snapshot = snapshotHolder.pop();
                inputText.restoreSnapshot(snapshot);
                System.out.println(snapshot.getText());
            } else {
                inputText.append(input);
                Snapshot snapshot = inputText.createSnapshot();
                snapshotHolder.push(snapshot);
            }
        }
    }
}
