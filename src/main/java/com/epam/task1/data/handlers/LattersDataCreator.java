package com.epam.task1.data.handlers;


import com.epam.task1.constant.Constant;
import com.epam.task1.data.model.Letter;
import com.epam.task1.data.model.Letters;
import com.epam.task1.data.utils.JAXBContextProcessor;
import com.epam.task1.data.utils.*;
import org.apache.log4j.Logger;

import java.io.File;

public class LattersDataCreator {
    private static final Logger LOG = Logger.getLogger(LattersDataCreator.class);
    private Letters letters;

    public Letters getLetters(){
        readFromXml();
        setRandomSubjects();
        LOG.info("\n"+letters.toString());
        return letters;
    }

    private void readFromXml(){
        JAXBContextProcessor jAXBContextProcessor = new JAXBContextProcessor(new Class[] { Letters.class});
        Object2Xml xmlAdapter = new Object2Xml(jAXBContextProcessor);
        letters=new Letters();
        letters=xmlAdapter.load(new File(Constant.LETTERS_XML_FILE_PATH));
    }
    private void setRandomSubjects(){
        RandomStringGenerator randomStringGenerator=new RandomStringGenerator();
        for (int i=0;i<letters.size();i++){
            Letter currentLetter=letters.getLetter(i);
            String letterSubject=randomStringGenerator.generate(10);
            currentLetter.setMessageSubject(letterSubject);
        }
    }

}
