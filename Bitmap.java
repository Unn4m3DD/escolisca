package aula7;


class Bitmap {
	BitmapFileHeader bitmapFileHeader;
	BitmapInfoHeader bitmapInfoHeader;
	byte[] rgbQuad; // color pallete – opcional (ver abaixo)
	byte[] data; // pixel data
	
	public Bitmap(BitmapFileHeader bitmapFileHeader, BitmapInfoHeader bitmapInfoHeader, byte[] rgbQuad, byte[] data) {
		this.bitmapFileHeader = bitmapFileHeader;
		this.bitmapInfoHeader = bitmapInfoHeader;
		this.rgbQuad = rgbQuad;
		this.data = data;
	}
	public Bitmap(BitmapFileHeader bitmapFileHeader, BitmapInfoHeader bitmapInfoHeader,  byte[] data) {
		this.bitmapFileHeader = bitmapFileHeader;
		this.bitmapInfoHeader = bitmapInfoHeader;
		this.data = data;
	}
}
class BitmapFileHeader {
	short type; // must be 'BM' to declare a bmp-file
	int size; // specifies the size of the file in bytes
	short reserved1; // must always be set to zero
	short reserved2; // must always be set to zero
	int offBits; // specifies the offset from the
	// beginning of the file to the bitmap data
	public BitmapFileHeader(short type, int size, short reserved1, short reserved2, int offBits) {
		this.type = type;
		this.size = size;
		this.reserved1 = reserved1;
		this.reserved2 = reserved2;
		this.offBits = offBits;
	}
}
class BitmapInfoHeader{
	int size; // the size of this header (40 bytes)
	int width; // the bitmap width in pixels
	int height; // the bitmap height in pixels
	short planes; // the number of color planes being used. Must be set to 1
	short bitCount; // the number of bits per pixel (color depth) - 1, 4, 8, 16, 24, 32
	int compression; // the compression method being used
	int sizeImage; // the image size. This is the size of the raw bitmap data
	int xPelsPerMeter; // the horizontal resolution of the image (pixel per meter)
	int yPelsPerMeter; // the vertical resolution of the image (pixel per meter)
	int clrUsed; // the number of colors in the color palette,
	// or 0 to default to 2n
	int clrImportant; // the number of important colors used,
	// or 0 when every color is important
	
	public BitmapInfoHeader(int size, int width, int height, short planes, short bitCount, int compression, int sizeImage, int xPelsPerMeter, int yPelsPerMeter,int crlUsed, int crlImportant) {
		this.size = size;
		this.width = width;
		this.height = height;
		this.planes = planes;
		this.bitCount = bitCount;
		this.compression = compression;
		this.sizeImage = sizeImage;
		this.xPelsPerMeter = xPelsPerMeter;
		this.yPelsPerMeter = yPelsPerMeter;
		this.clrUsed = crlUsed;
		this.clrImportant = crlImportant;
	}
}
