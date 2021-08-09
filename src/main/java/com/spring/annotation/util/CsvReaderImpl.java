package com.spring.annotation.util;

import org.springframework.stereotype.Repository;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.dozer.CsvDozerBeanReader;
import org.supercsv.io.dozer.ICsvDozerBeanReader;
import org.supercsv.prefs.CsvPreference;
import com.spring.annotation.entity.Quiz;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Repository
public class CsvReaderImpl implements CsvReader {
    private static final String[] FIELD = new String[]{
            "questionNumber",
            "question",
            "answer"
    };
    private static final CellProcessor[] processors = new CellProcessor[]{
            new NotNull(new ParseInt()),
            new NotNull(),
            new NotNull(new ParseInt())
    };

    @Override
    public List<Quiz> readQuestionsFromSource() throws Exception {
        List<Quiz> questions = new ArrayList<>();
        Locale.setDefault(Locale.ENGLISH);
        ClassLoader classLoader = getClass().getClassLoader();
        File source;
        source = new File(classLoader.getResource("source_en.csv").getFile());
        try (ICsvDozerBeanReader reader = new CsvDozerBeanReader(new FileReader(source),
                CsvPreference.STANDARD_PREFERENCE)) {
            reader.getHeader(true);
            reader.configureBeanMapping(Quiz.class, FIELD);
            Quiz question;
            while ((question = reader.read(Quiz.class, processors)) != null) {
                questions.add(question);
            }
        }
        return questions;
    }
}
