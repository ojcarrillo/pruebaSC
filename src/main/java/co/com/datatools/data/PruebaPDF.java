package co.com.datatools.data;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;

import com.itextpdf.text.Document;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.Barcode;
import com.itextpdf.text.pdf.BarcodeEAN;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

public class PruebaPDF {

	public void generarPDF(Object[] arguments) {

		StringBuilder html = new StringBuilder();
		html.append("<html>");
		html.append("<head>");
		html.append("<style> @page '{' margin: 20px 25px;  size: 5.5in 3.5in portrait; '}'");

		html.append("body '{' font-family: Arial, Helvetica, sans-serif; font-size:5pt; '}' ");
		html.append("table td '{' padding: 5px 2px;  border:solid 1px; '}'");
		html.append(
				".column '{' float: left; width: 45%; padding: 5px; '}' .row::after '{' content: \"\"; clear: both; display: table; '}' ");

		html.append("</style>");
		html.append("</head>");
		html.append("<body>");

		html.append(
				"<table border=\"1\" cellspacing=\"0\" cellpadding=\"5\" style=\"border-collapse:collapse;width:100%;\" class=\"ckeditorItem\" x=\"0\" y=\"0\" ancho_item=\"698\" alto_item=\"189\">");
		html.append("    <tbody>");
		html.append("        <tr x=\"0\" y=\"0\" ancho_item=\"699\" alto_item=\"18\" tipo=\"fila\">");
		html.append(
				"            <td colspan=\"5\" class=\"cellborde\" style=\"text-align:center; padding: 5px;\" x=\"0\" y=\"0\" ancho_item=\"697\" alto_item=\"16\"><strong>CUPON DE PAGO</strong></td>");
		html.append("        </tr>");
		html.append("        <tr x=\"0\" y=\"18\" ancho_item=\"650\" alto_item=\"18\" tipo=\"fila\">");
		html.append(
				"            <td rowspan=\"3\" colspan=\"2\" x=\"0\" y=\"18\" ancho_item=\"603\" alto_item=\"52\" style=\"width:500px;\">");
		html.append("               <img src=\"c:\\temp\\cisa.png\" />");
		html.append("            </td>");
		html.append("<td rowspan=\"3\" colspan=\"2\" ><img src=\"{10}\" /></td>");
		html.append(
				"            <td style=\"width:186px;border:solid 1px;\" x=\"418\" y=\"18\" ancho_item=\"116\" alto_item=\"16\" >NUMERO</td>");
		html.append(
				"            <td style=\"width:156px;border:solid 1px;text-align:center;\" x=\"536\" y=\"18\" ancho_item=\"161\" alto_item=\"16\" >{0}</td>");
		html.append("        </tr>");
		html.append("        <tr x=\"0\" y=\"36\" ancho_item=\"699\" alto_item=\"18\" tipo=\"fila\">");
		html.append(
				"            <td style=\"width:186px;border:solid 1px;\" x=\"418\" y=\"36\" ancho_item=\"116\" alto_item=\"16\" >FECHA EXPEDICION</td>");
		html.append(
				"            <td style=\"width:156px;border:solid 1px;text-align:center;\" x=\"536\" y=\"36\" ancho_item=\"161\" alto_item=\"16\" >{1}</td>");
		html.append("        </tr>");
		html.append("        <tr x=\"0\" y=\"36\" ancho_item=\"699\" alto_item=\"18\" tipo=\"fila\">");
		html.append(
				"            <td style=\"width:186px;border:solid 1px;\" x=\"418\" y=\"36\" ancho_item=\"116\" alto_item=\"16\" >OBLIGACION</td>");
		html.append(
				"            <td style=\"width:156px;border:solid 1px;text-align:center;\" x=\"536\" y=\"36\" ancho_item=\"161\" alto_item=\"16\" >{2}</td>");
		html.append("        </tr>");

		html.append("        <tr x=\"0\" y=\"90\" ancho_item=\"699\" alto_item=\"18\" tipo=\"fila\">");
		html.append(
				"            <td rowspan=\"2\" colspan=\"1\" style=\"width:95px;\" x=\"0\" y=\"90\" ancho_item=\"97\" alto_item=\"34\">DEUDOR</td>");
		html.append(
				"            <td style=\"width:114px;\" x=\"99\" y=\"90\" ancho_item=\"116\" alto_item=\"16\">IDENTIFICACION</td>");
		html.append(
				"            <td rowspan=\"1\" colspan=\"3\" style=\"width:194px;\" x=\"217\" y=\"90\" ancho_item=\"480\" alto_item=\"16\">{3}</td>");
		html.append("        </tr>");
		html.append("        <tr x=\"0\" y=\"108\" ancho_item=\"699\" alto_item=\"18\" tipo=\"fila\">");
		html.append(
				"            <td style=\"width:114px; border:solid 1px;\" x=\"99\" y=\"108\" ancho_item=\"116\" alto_item=\"16\">NOMBRE</td>");
		html.append(
				"            <td rowspan=\"1\" colspan=\"3\" style=\"width:194px; border:solid 1px;\" x=\"217\" y=\"108\" ancho_item=\"480\" alto_item=\"16\">{4}</td>");
		html.append("        </tr>");
		html.append("		<tr x=\"0\" y=\"126\" ancho_item=\"699\" alto_item=\"18\" tipo=\"fila\">");
		html.append(
				"            <td rowspan=\"1\" colspan=\"4\" style=\"width:96px;border: solid 1px;\" x=\"0\" y=\"126\" ancho_item=\"416\" alto_item=\"16\">Saldo a pagar, con 12% EA, liquidado a la fecha de expedicion</td>");
		html.append(
				"            <td colspan=\"1\" style=\"width:156px;text-align:right;\" x=\"536\" y=\"126\" ancho_item=\"161\" alto_item=\"16\">{5}</td>");
		html.append("        </tr>");
		html.append("        <tr x=\"0\" y=\"144\" ancho_item=\"699\" alto_item=\"18\" tipo=\"fila\">");
		html.append(
				"            <td rowspan=\"3\" colspan=\"3\" style=\"width:95px; height:50px; border: solid 1px;\" x=\"0\" y=\"144\" ancho_item=\"697\" alto_item=\"16\">{6}</td>			");
		html.append(
				"            <td style=\"width:186px\" x=\"418\" y=\"36\" ancho_item=\"116\" alto_item=\"16\" >SALDO CAPITAL:</td>");
		html.append(
				"            <td style=\"width:156px;text-align:right;\" x=\"536\" y=\"36\" ancho_item=\"161\" alto_item=\"16\" >{7}</td>");
		html.append("        </tr>");
		html.append("		<tr x=\"0\" y=\"36\" ancho_item=\"699\" alto_item=\"18\" tipo=\"fila\">");
		html.append(
				"            <td style=\"width:186px\" x=\"418\" y=\"36\" ancho_item=\"116\" alto_item=\"16\" >INTERESES (12% EA):</td>");
		html.append(
				"            <td style=\"width:156px;text-align:right;\" x=\"536\" y=\"36\" ancho_item=\"161\" alto_item=\"16\" >{8}</td>");
		html.append("        </tr>");
		html.append("		<tr x=\"0\" y=\"36\" ancho_item=\"699\" alto_item=\"18\" tipo=\"fila\">");
		html.append(
				"            <td style=\"width:186px\" x=\"418\" y=\"36\" ancho_item=\"116\" alto_item=\"16\" >TOTAL INTERES USURA:</td>");
		html.append(
				"            <td style=\"width:156px;text-align:right;\" x=\"536\" y=\"36\" ancho_item=\"161\" alto_item=\"16\" >{9}</td>");
		html.append("       </tr>");
		html.append("    </tbody>");
		html.append("</table>");
		html.append("</body>");
		html.append("</html>");

		try {
			ByteArrayOutputStream file = new ByteArrayOutputStream();
			Document document = new Document();
			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream(FILE + (new Date()).getTime() + ".pdf"));
			document.setPageSize(new Rectangle(670, 340));
			document.open();
			String barcode = "data:image/png;base64, "
					+ new String(Base64.encodeBase64(generateCodeBar(writer, (String) arguments[0])), "UTF-8");

			InputStream is = new ByteArrayInputStream(
					MessageFormat.format(html.toString(), appendValue(arguments, barcode)).getBytes());
			XMLWorkerHelper.getInstance().parseXHtml(writer, document, is);
			document.close();
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public byte[] generateCodeBar(PdfWriter writer, String code) throws IOException {

		BarcodeEAN barcode = new BarcodeEAN();
		barcode.setCodeType(Barcode.EAN8);
		barcode.setCode(code);
		barcode.setStartStopText(false);
		barcode.setExtended(true);
		java.awt.Image rawImage = barcode.createAwtImage(Color.BLACK, Color.WHITE);
		BufferedImage outImage = new BufferedImage(rawImage.getWidth(null), rawImage.getHeight(null),
				BufferedImage.TYPE_INT_RGB);
		outImage.getGraphics().drawImage(rawImage, 0, 0, null);
		ByteArrayOutputStream bytesOut = new ByteArrayOutputStream();
		ImageIO.write(outImage, "png", bytesOut);
		bytesOut.flush();
		return bytesOut.toByteArray();
	}

	private static String FILE = "c:/temp/FirstPdf";

	private Object[] appendValue(Object[] obj, Object newObj) {

		ArrayList<Object> temp = new ArrayList<Object>(Arrays.asList(obj));
		temp.add(newObj);
		return temp.toArray();

	}
}
