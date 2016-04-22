package nl.dictu.prova.plugins.input.msexcel.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Checks if a sheet has a name with a valid prefix to be considered as the starting point of a new test case.
 * All characters up to but not including the first underscore are assumed to be the prefix of the sheet name.
 * <p>
 * Currently allowed prefixes:
 * - WEB: web test
 * - SH:  shell test
 *
 * @author Hielke de Haan
 * @since 0.0.1
 */
public class SheetPrefixValidator
{
  private final static Logger LOGGER = LogManager.getLogger();
  private final static List<String> ALLOWED_PREFIXES = Arrays.asList("WEB", "SH");
  private Sheet sheet;

  public SheetPrefixValidator(Sheet sheet)
  {
    this.sheet = sheet;
  }

  public boolean validate()
  {
    String sheetNamePrefix = getSheetNamePrefix(sheet);
    boolean allowed = ALLOWED_PREFIXES.contains(sheetNamePrefix);
    LOGGER.debug("Prefix = {}: {}", sheetNamePrefix, allowed ? "process" : "ignore");
    return allowed;
  }

  private String getSheetNamePrefix(Sheet sheet)
  {
    Pattern pattern = Pattern.compile("^([A-Za-z0-9]+)_[A-Za-z0-9_]+$");
    Matcher matcher = pattern.matcher(sheet.getSheetName());
    String prefix;

    if (matcher.find())
      prefix = matcher.group(1);
    else
      prefix = null;

    return prefix;
  }
}