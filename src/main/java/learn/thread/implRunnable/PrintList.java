package learn.thread.implRunnable;

import java.util.ArrayList;
import java.util.List;

public class PrintList {

    private final List<String> strings;

    PrintList() {
        this.strings = new ArrayList<>();
    }

    public void addToStrings(String s) {
        this.strings.add(s);
    }

    public String getStrings() {
        return this.strings.toString();
    }
}
