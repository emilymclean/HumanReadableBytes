package cl.emilym.bytes;

import cl.emilym.bytes.HumanReadableBytes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HumanReadableBytesTest {

    @Test
    public void testSi() {
        assertEquals("0B", HumanReadableBytes.si(0));
        assertEquals("1B", HumanReadableBytes.si(1));
        assertEquals("999B", HumanReadableBytes.si(999));
        assertEquals("1.0kB", HumanReadableBytes.si(1000));
        assertEquals("1.5kB", HumanReadableBytes.si(1500));
        assertEquals("2.5kB", HumanReadableBytes.si(2500));
        assertEquals("999.0kB", HumanReadableBytes.si(999_000));
        assertEquals("1.0MB", HumanReadableBytes.si(1_000_000));
        assertEquals("1.5MB", HumanReadableBytes.si(1_500_000));
        assertEquals("2.5MB", HumanReadableBytes.si(2_500_000));
        assertEquals("999.0MB", HumanReadableBytes.si(999_000_000));
        assertEquals("1.0GB", HumanReadableBytes.si(1_000_000_000));
        assertEquals("1.5GB", HumanReadableBytes.si(1_500_000_000));
        assertEquals("2.5GB", HumanReadableBytes.si(2_500_000_000L));
    }

    @Test
    public void testSiRound() {
        assertEquals("0B", HumanReadableBytes.si(0, 0));
        assertEquals("1B", HumanReadableBytes.si(1, 0));
        assertEquals("999B", HumanReadableBytes.si(999, 0));
        assertEquals("1kB", HumanReadableBytes.si(1000, 0));
        assertEquals("2kB", HumanReadableBytes.si(1500, 0));
        assertEquals("3kB", HumanReadableBytes.si(2500, 0));
        assertEquals("999kB", HumanReadableBytes.si(999_000, 0));
        assertEquals("1MB", HumanReadableBytes.si(1_000_000, 0));
        assertEquals("2MB", HumanReadableBytes.si(1_500_000, 0));
        assertEquals("3MB", HumanReadableBytes.si(2_500_000, 0));
        assertEquals("999MB", HumanReadableBytes.si(999_000_000, 0));
        assertEquals("1GB", HumanReadableBytes.si(1_000_000_000, 0));
        assertEquals("2GB", HumanReadableBytes.si(1_500_000_000, 0));
        assertEquals("3GB", HumanReadableBytes.si(2_500_000_000L, 0));
    }

    @Test
    public void testSiSpace() {
        assertEquals("0 B", HumanReadableBytes.si(0, 0, true));
        assertEquals("1 B", HumanReadableBytes.si(1, 0, true));
        assertEquals("999 B", HumanReadableBytes.si(999, 0, true));
        assertEquals("1 kB", HumanReadableBytes.si(1000, 0, true));
        assertEquals("2 kB", HumanReadableBytes.si(1500, 0, true));
        assertEquals("3 kB", HumanReadableBytes.si(2500, 0, true));
        assertEquals("999 kB", HumanReadableBytes.si(999_000, 0, true));
        assertEquals("1 MB", HumanReadableBytes.si(1_000_000, 0, true));
        assertEquals("2 MB", HumanReadableBytes.si(1_500_000, 0, true));
        assertEquals("3 MB", HumanReadableBytes.si(2_500_000, 0, true));
        assertEquals("999 MB", HumanReadableBytes.si(999_000_000, 0, true));
        assertEquals("1 GB", HumanReadableBytes.si(1_000_000_000, 0, true));
        assertEquals("2 GB", HumanReadableBytes.si(1_500_000_000, 0, true));
        assertEquals("3 GB", HumanReadableBytes.si(2_500_000_000L, 0, true));
    }

    @Test
    public void testBi() {
        assertEquals("0B", HumanReadableBytes.bi(0));
        assertEquals("1B", HumanReadableBytes.bi(1));
        assertEquals("999B", HumanReadableBytes.bi(999));
        assertEquals("1.0KiB", HumanReadableBytes.bi(1024));
        assertEquals("1.5KiB", HumanReadableBytes.bi(1536));
        assertEquals("2.5KiB", HumanReadableBytes.bi(2560));
        assertEquals("999.0KiB", HumanReadableBytes.bi(1_022_976));
        assertEquals("1.0MiB", HumanReadableBytes.bi(1_048_576));
        assertEquals("1.5MiB", HumanReadableBytes.bi(1_572_864));
        assertEquals("2.5MiB", HumanReadableBytes.bi(2_621_440));
        assertEquals("999.0MiB", HumanReadableBytes.bi(1_047_527_424));
        assertEquals("1.0GiB", HumanReadableBytes.bi(1_073_741_824));
        assertEquals("1.5GiB", HumanReadableBytes.bi(1_610_612_736));
        assertEquals("2.5GiB", HumanReadableBytes.bi(2_684_354_560L));
    }

    @Test
    public void testBiRound() {
        assertEquals("0B", HumanReadableBytes.bi(0, 0));
        assertEquals("1B", HumanReadableBytes.bi(1, 0));
        assertEquals("999B", HumanReadableBytes.bi(999, 0));
        assertEquals("1KiB", HumanReadableBytes.bi(1024, 0));
        assertEquals("2KiB", HumanReadableBytes.bi(1536, 0));
        assertEquals("3KiB", HumanReadableBytes.bi(2560, 0));
        assertEquals("999KiB", HumanReadableBytes.bi(1_022_976, 0));
        assertEquals("1MiB", HumanReadableBytes.bi(1_048_576, 0));
        assertEquals("2MiB", HumanReadableBytes.bi(1_572_864, 0));
        assertEquals("3MiB", HumanReadableBytes.bi(2_621_440, 0));
        assertEquals("999MiB", HumanReadableBytes.bi(1_047_527_424, 0));
        assertEquals("1GiB", HumanReadableBytes.bi(1_073_741_824, 0));
        assertEquals("2GiB", HumanReadableBytes.bi(1_610_612_736, 0));
        assertEquals("3GiB", HumanReadableBytes.bi(2_684_354_560L, 0));
    }

    @Test
    public void testBiSpace() {
        assertEquals("0 B", HumanReadableBytes.bi(0, 0, true));
        assertEquals("1 B", HumanReadableBytes.bi(1, 0, true));
        assertEquals("999 B", HumanReadableBytes.bi(999, 0, true));
        assertEquals("1 KiB", HumanReadableBytes.bi(1024, 0, true));
        assertEquals("2 KiB", HumanReadableBytes.bi(1536, 0, true));
        assertEquals("3 KiB", HumanReadableBytes.bi(2560, 0, true));
        assertEquals("999 KiB", HumanReadableBytes.bi(1_022_976, 0, true));
        assertEquals("1 MiB", HumanReadableBytes.bi(1_048_576, 0, true));
        assertEquals("2 MiB", HumanReadableBytes.bi(1_572_864, 0, true));
        assertEquals("3 MiB", HumanReadableBytes.bi(2_621_440, 0, true));
        assertEquals("999 MiB", HumanReadableBytes.bi(1_047_527_424, 0, true));
        assertEquals("1 GiB", HumanReadableBytes.bi(1_073_741_824, 0, true));
        assertEquals("2 GiB", HumanReadableBytes.bi(1_610_612_736, 0, true));
        assertEquals("3 GiB", HumanReadableBytes.bi(2_684_354_560L, 0, true));
    }

}