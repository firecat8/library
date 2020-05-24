package com.library.domain.ddc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gdimitrova
 */
public class DeweyDecimalClassification {

    private final static Logger LOGGER = Logger.getLogger(DeweyDecimalClassification.class.getName());

    private final String sectionsFile = "ddcSections.txt";

    private Map<String, DeweyClassSection> sections;

    public DeweyDecimalClassification() {
        loadSections();
    }

    private void loadSections() {
        Map<String, DeweyClassSection> readed = new HashMap<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(sectionsFile));
            lines.forEach(l -> {
                String[] arr = l.split("-");
                readed.put(arr[0], new DeweyClassSection(arr[0], arr[1]));
            });
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
        sections = Collections.unmodifiableMap(readed);
    }

    public DeweyClassSection getSection(String code) {
        return sections.get(code);
    }

}
