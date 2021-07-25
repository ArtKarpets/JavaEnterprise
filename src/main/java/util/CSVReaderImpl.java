package util;

import entity.Quiz;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.dozer.CsvDozerBeanReader;
import org.supercsv.io.dozer.ICsvDozerBeanReader;
import org.supercsv.prefs.CsvPreference;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CSVReaderImpl implements CSVReader {
    private static final String[] FIELDS = new String[]{
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
    public List<Quiz> readQuestions() throws Exception {
        List<Quiz> questions = new ArrayList<>();
        ClassLoader classLoader = getClass().getClassLoader();
        File source = new File(Objects.requireNonNull(classLoader.getResource("data/questions.csv")).getFile());
        try (ICsvDozerBeanReader reader = new CsvDozerBeanReader(new FileReader(source),
                CsvPreference.STANDARD_PREFERENCE)) {
            reader.getHeader(true);
            reader.configureBeanMapping(Quiz.class, FIELDS);
            Quiz question;
            while ((question = reader.read(Quiz.class, processors)) != null) {
                questions.add(question);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questions;
    }
}


