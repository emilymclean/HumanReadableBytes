package cl.emilym.bytes;

import java.math.RoundingMode;
import java.text.CharacterIterator;
import java.text.DecimalFormat;
import java.text.StringCharacterIterator;

/**
 * Utility class for converting byte counts into human-readable formats.
 * Provides methods for both base 10 (SI) and base 2 (IEC) conversions.
 */
public class HumanReadableBytes {

    private HumanReadableBytes() {}

    /**
     * Base 10 conversion of bytes into a human-readable SI format (MB as opposed to MiB),
     * with 1 decimal place of precision.
     * @param bytes The byte count of the data
     * @return Base 10 conversion of bytes into a human-readable format. For example, 1000
     * bytes would be formatted as "1kB".
     */
    public static String si(
            long bytes
    ) {
        return si(bytes, 1);
    }

    /**
     * Base 10 conversion of bytes into a human-readable SI format (MB as opposed to MiB),
     * with <code>decimalPlaces</code> level of precision.
     * @param bytes The byte count of the data
     * @param decimalPlaces The number of decimal places to show
     * @return Base 10 conversion of bytes into a human-readable format. For example, 1000
     * bytes would be formatted as "1kB".
     */
    public static String si(
            long bytes,
            int decimalPlaces
    ) {
        return si(bytes, decimalPlaces, false);
    }

    /**
     * Base 10 conversion of bytes into a human-readable SI format (MB as opposed to MiB),
     * with <code>decimalPlaces</code> level of precision.
     * @param bytes The byte count of the data
     * @param decimalPlaces The number of decimal places to show
     * @param space Whether to separate the decimal and unit with a space (i.e. 10kB vs 10 kB)
     * @return Base 10 conversion of bytes into a human-readable format. For example, 1000
     * bytes would be formatted as "1kB".
     */
    public static String si(
            long bytes,
            int decimalPlaces,
            boolean space
    ) {
        String separator = space ? " " : "";
        if (-1000 < bytes && bytes < 1000) {
            return String.format("%d%sB", bytes, separator);
        }
        CharacterIterator ci = new StringCharacterIterator("kMGTPE");
        while (bytes <= -999_950 || bytes >= 999_950) {
            bytes /= 1000;
            ci.next();
        }

        String formatString = "%s%s%cB";
        return String.format(formatString, rounded(bytes / 1000.0, decimalPlaces), separator, ci.current());
    }

    /**
     * Base 2 conversion of bytes into a human-readable IEC format (MiB as opposed to MB),
     * with 1 decimal place of precision.
     * @param bytes The byte count of the data
     * @return Base 2 conversion of bytes into a human-readable format. For example, 1024
     * bytes would be formatted as "1KiB".
     */
    public static String bi(
            long bytes
    ) {
        return bi(bytes, 1);
    }

    /**
     * Base 2 conversion of bytes into a human-readable IEC format (MiB as opposed to MB),
     * with <code>decimalPlaces</code> level of precision.
     * @param bytes The byte count of the data
     * @param decimalPlaces The number of decimal places to show
     * @return Base 2 conversion of bytes into a human-readable format. For example, 1024
     * bytes would be formatted as "1KiB".
     */
    public static String bi(
            long bytes,
            int decimalPlaces
    ) {
        return bi(bytes, decimalPlaces, false);
    }

    /**
     * Base 2 conversion of bytes into a human-readable IEC format (MiB as opposed to MB),
     * with <code>decimalPlaces</code> level of precision.
     * @param bytes The byte count of the data
     * @param decimalPlaces The number of decimal places to show
     * @param space Whether to separate the decimal and unit with a space (i.e. 10kB vs 10 kB)
     * @return Base 2 conversion of bytes into a human-readable format. For example, 1024
     * bytes would be formatted as "1KiB".
     */
    public static String bi(
            long bytes,
            int decimalPlaces,
            boolean space
    ) {
        String separator = space ? " " : "";
        if (-1024 < bytes && bytes < 1024) {
            return String.format("%d%sB", bytes, separator);
        }
        CharacterIterator ci = new StringCharacterIterator("KMGTPE");
        while (bytes <= -1_048_576 || bytes >= 1_048_576 /* 1024 * 1024 */) {
            bytes /= 1024;
            ci.next();
        }

        String formatString = "%s%s%ciB";
        return String.format(formatString, rounded(bytes / 1024.0, decimalPlaces), separator, ci.current());
    }

    private static String rounded(
            double bytes,
            int decimalPlaces
    ) {
        if (decimalPlaces == 0) return String.format("%.0f", bytes);

        DecimalFormat df = new DecimalFormat("0." + new String(new char[decimalPlaces]).replace("\0", "#"));
        df.setRoundingMode(RoundingMode.HALF_UP);
        return df.format(bytes);
    }

}
