package crew.milo.common.util;

import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.time.Instant;
import java.util.Random;
import java.util.UUID;

public class UuidUtils {
    private static final Random random = new SecureRandom();

    private UuidUtils() {
    }

    public static UUID randomUuidV7() {
        long timestamp = Instant.now().toEpochMilli();
        byte[] bytes = new byte[16];
        random.nextBytes(bytes);

        ByteBuffer.wrap(bytes).putLong(0, timestamp << 16 | (bytes[6] & 0x0FFF));

        bytes[6] = (byte) ((bytes[6] & 0x0F) | 0x70);
        bytes[8] = (byte) ((bytes[8] & 0x3F) | 0x80);

        ByteBuffer bb = ByteBuffer.wrap(bytes);
        long mostSigBits = bb.getLong();
        long leastSigBits = bb.getLong();

        return new UUID(mostSigBits, leastSigBits);
    }
}