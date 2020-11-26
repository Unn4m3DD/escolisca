package myUtilAula7;

public class ByteUtil {

    public static byte[] toBytes(short i) {
        byte[] result = new byte[2];

        result[1] = (byte) (i >> 8);
        result[0] = (byte) (i /*>> 0*/);

        return result;
    }

    public static byte[] toBytes(int i) {
        byte[] result = new byte[4];

        result[3] = (byte) (i >> 24);
        result[2] = (byte) (i >> 16);
        result[1] = (byte) (i >> 8);
        result[0] = (byte) (i /*>> 0*/);

        return result;
    }
}
