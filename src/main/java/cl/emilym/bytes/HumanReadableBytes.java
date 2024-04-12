package cl.emilym.bytes;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Locale;

public class HumanReadableBytes {

    public static String si(
            long bytes
    ) {
        return si(bytes, 1);
    }

    // From https://stackoverflow.com/questions/3758606/how-can-i-convert-byte-size-into-a-human-readable-format-in-java
    public static String si(
            long bytes,
            int decimalPlaces
    ) {
        if (-1000 < bytes && bytes < 1000) {
            return bytes + "B";
        }
        CharacterIterator ci = new StringCharacterIterator("kMGTPE");
        while (bytes <= -999_950 || bytes >= 999_950) {
            bytes /= 1000;
            ci.next();
        }
        return String.format("%." + decimalPlaces + "f%cB", bytes / 1000.0, ci.current());
    }

    public static String bi(
            long bytes
    ) {
        return bi(bytes, 1);
    }

    public static String bi(
            long bytes,
            int decimalPlaces
    ) {
        if (-1024 < bytes && bytes < 1024) {
            return bytes + "B";
        }
        CharacterIterator ci = new StringCharacterIterator("KMGTPE");
        while (bytes <= -1_048_576 || bytes >= 1_048_576 /* 1024 * 1024 */) {
            bytes /= 1024;
            ci.next();
        }

        return String.format("%." + decimalPlaces + "f%ciB", bytes / 1024.0, ci.current());
    }

}
