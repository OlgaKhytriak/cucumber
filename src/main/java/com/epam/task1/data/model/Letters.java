package com.epam.task1.data.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "letters")
@XmlSeeAlso({Letter.class})
@XmlAccessorType(XmlAccessType.FIELD)

public class Letters {
    @XmlElement(name = "letter")
    private List<Letter> letterList;

    public Letters() {
        letterList = new ArrayList<Letter>();
    }

    public void add(Letter letter) {
        this.letterList.add(letter);
    }

    public int size() {
        return letterList.size();
    }

    public Letter getLetter(int index) {
        return letterList.get(index);
    }

    public List<Letter> getLetters() {
        return letterList;
    }

    public void setLetters(List<Letter> letterList) {
        this.letterList = letterList;
    }

    public String toString() {
        StringBuilder rez = new StringBuilder();
        for (Letter letter : letterList) {
            rez.append(letter.toString());
            rez.append("\n");
        }
        return rez.toString();
    }
}

