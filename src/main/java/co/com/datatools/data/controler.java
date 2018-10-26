package co.com.datatools.data;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.jayway.jsonpath.Criteria;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.JsonPath;

@RestController
public class controler {

	@GET
	@RequestMapping(path = "/prueba/", produces = { "application/JSON" })
	public Response prueba() {
		String query = "https://qa.scmail.co/ws/rest/sendEmail";
		String json = "{\r\n" + "  \"fromName\" : \"Alex Chacón\",\r\n"
				+ "  \"fromAddress\" : \"alex.chacon@software-colombia.com\",\r\n" + "  \"recipients\" :\r\n"
				+ "    [\r\n" + "    \"yepezwow@gmail.com\"\r\n" + "    ],\r\n"
				+ "  \"subject\" : \"Envío correo electrónico certificado 23\",\r\n" + "  \"templateId\": 361,\r\n"
				+ "  \"metadata\": [\r\n" + "    {\"tag\": \"uno\", \"value\":\"uno\"},\r\n"
				+ "    {\"tag\": \"multa\", \"value\":\"123456789\"}\r\n" + "    ],\r\n" + "  \"attachments\": [\r\n"
				+ "    {\"name\": \"test123.txt\", \"data\":\"cHJ1ZWJhIGNvcnJlbw==\"}\r\n" + "    ]  \r\n" + "}";

		json = "{\r\n" + "    \"tool\":\r\n" + "    {\r\n" + "        \"jsonpath\":\r\n" + "        {\r\n"
				+ "            \"creator\":\r\n" + "            {\r\n"
				+ "                \"name\": \"Jayway Inc.\",\r\n" + "                \"location\":\r\n"
				+ "                [\r\n" + "                    \"Malmo\",\r\n"
				+ "                    \"San Francisco\",\r\n" + "                    \"Helsingborg\"\r\n"
				+ "                ]\r\n" + "            }\r\n" + "        }\r\n" + "    },\r\n" + " \r\n"
				+ "    \"book\":\r\n" + "    [\r\n" + "        {\r\n" + "            \"title\": \"Beginning JSON\",\r\n"
				+ "            \"price\": 49.99\r\n" + "        },\r\n" + " \r\n" + "        {\r\n"
				+ "            \"title\": \"JSON at Work\",\r\n" + "            \"price\": 29.99\r\n" + "        }\r\n"
				+ "    ]\r\n" + "}";
		String json2 = "{\"comparendoDTO\":{\"cicomparendo\":1005309,\"ordenComparendoNacional\":{\"cicomparendo\":1005309,\"numeroComparendo\":\"44441234\",\"organismoTransito\":{\"codigoOrganismo\":11001,\"actualizando\":false}},\"tipoOrigen\":{\"id\":1},\"usuarioPersona\":{\"usuario\":{\"roles\":[],\"id\":-1,\"autenticacionConLdap\":false}},\"medioImposicion\":{\"id\":2},\"fechaInfraccion\":\"Oct 3, 2018 12:00:00 AM\",\"horaInfraccion\":\"08:00:00 AM\",\"fechaModificacion\":\"Oct 9, 2018 3:25:48 PM\",\"direccion\":{\"id\":7652703,\"tipoViaPrincipal\":{\"codigo\":0},\"nombreViaPrincipal\":{},\"cardinalidadViaPrincipal\":{},\"tipoViaSecundaria\":{},\"nombreViaSecundaria\":{},\"cardinalidadViaSecundaria\":{},\"complemento\":\"Perimetral - Ceibos Norte 1\",\"municipio\":{\"id\":89},\"localidad\":{},\"tipoUbicabilidad\":{},\"tipoCoordenada\":{},\"pais\":{\"id\":58},\"departamento\":{\"id\":10}},\"existeFugaInfractor\":false,\"infraccion\":{\"id\":107},\"tipoComparendo\":{\"id\":1},\"estadoComparendo\":{\"id\":1},\"fechaRegistro\":\"Oct 9, 2018 3:25:48 PM\",\"niegaPruebaAlcoholemia\":false,\"carteraGenerada\":false,\"comparendoAgente\":{\"id\":392291,\"comparendo\":{\"cicomparendo\":1005309,\"fechaInfraccion\":\"Oct 3, 2018 12:00:00 AM\",\"horaInfraccion\":\"08:00:00 AM\",\"fechaModificacion\":\"Oct 9, 2018 3:25:48 PM\",\"existeFugaInfractor\":false,\"fechaRegistro\":\"Oct 9, 2018 3:25:48 PM\",\"niegaPruebaAlcoholemia\":false,\"carteraGenerada\":false,\"numeroCitacion\":\"12121\",\"idFacturaAxis\":44441234,\"placaAgenteTransito\":\"170\",\"oficina\":\"ATP\",\"idOficinaTrx\":\"\",\"idCanalTrx\":\"\"},\"agente\":{\"id\":16},\"tipoIdentificacionPersona\":{\"id\":1},\"numeroIdentificacion\":\"0926316993\",\"placa\":\"170\",\"apellido1\":\"Carrillo\",\"apellido2\":\"Alvarado\",\"nombre1\":\"Anggie\",\"nombre2\":\"Iliana\"},\"comparendoVehiculo\":{\"id\":1005309,\"placaVehiculo\":\"GIN0971\"},\"personaList\":[{\"id\":842041,\"comparendo\":{\"cicomparendo\":1005309},\"tipoPersonaComparendo\":{\"codigo\":2},\"persona\":{\"id\":31665,\"validarCamposMinimos\":false},\"tipoIdentificacion\":{\"id\":1},\"numeroIdentificacion\":\"0904872140\",\"apellido1\":\"ENDARA\",\"apellido2\":\"ABBOTT\",\"nombre1\":\"MARY\",\"direccion\":{\"id\":7652704},\"fechaInicio\":\"Oct 3, 2018 12:00:00 AM\"}],\"trazabilidadComparendoList\":[{\"id\":3505406,\"fechaEjecucion\":\"Oct 3, 2018 8:00:00 AM\",\"fechaRegistro\":\"Oct 9, 2018 3:25:54 PM\",\"usuario\":{\"usuario\":{\"roles\":[],\"id\":-1,\"autenticacionConLdap\":false}},\"actividad\":{\"id\":1},\"comparendo\":{\"cicomparendo\":1005309},\"estadoComparendo\":{\"id\":1}},{\"id\":3505407,\"fechaEjecucion\":\"Oct 9, 2018 3:25:54 PM\",\"fechaRegistro\":\"Oct 9, 2018 3:25:54 PM\",\"usuario\":{\"usuario\":{\"roles\":[],\"id\":-1,\"autenticacionConLdap\":false}},\"actividad\":{\"id\":15},\"comparendo\":{\"cicomparendo\":1005309},\"estadoComparendo\":{\"id\":1}}],\"tipoAgenteImpositorDTO\":{\"id\":4},\"numeroCitacion\":\"12121\",\"idFacturaAxis\":44441234,\"placaAgenteTransito\":\"170\",\"oficina\":\"ATP\",\"idOficinaTrx\":\"\",\"idCanalTrx\":\"\"},\"tramite\":\"DeudorSolidario\"}";
		// try {
		// URL url = new URL(query);
		// HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		// conn.setConnectTimeout(5000);
		// conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		// conn.setRequestProperty("X-SCKEY-TOKEN",
		// "MzYx-sb4etUpq7CGtBf7LYUDrO3zXHp6dDomXDS2qYoBMbCO8p4x0HnnHyQnWddrqYBe1");
		// conn.setDoOutput(true);
		// conn.setDoInput(true);
		// conn.setRequestMethod("POST");
		//
		// OutputStream os = conn.getOutputStream();
		// os.write(json.getBytes("UTF-8"));
		// os.close();
		//
		// // read the response
		// BufferedReader br = new BufferedReader(new
		// InputStreamReader((conn.getInputStream())));
		//
		// String output;
		// StringBuilder respuestaWS = new StringBuilder();
		// while ((output = br.readLine()) != null) {
		// respuestaWS.append(output);
		// }
		// System.out.println(respuestaWS.toString());
		// conn.disconnect();
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		DocumentContext jsonContext = JsonPath.parse(json2);
		List<String> jsonpathCreatorLocation = jsonContext.read("$.comparendoDTO.personaList[*].tipoPersonaComparendo",
				Filter.filter(Criteria.where("codigo").eq(2)));
		Object nodo = jsonContext.read("$.comparendoDTO.personaList[?(@.tipoPersonaComparendo.codigo==2)]");
		return Response.status(Status.OK).entity(nodo).build();
	}

	@POST
	@RequestMapping(path = "/pruebapost_v/", consumes = { "application/JSON" }, produces = { "application/JSON" })
	public Response pruebapost_v(@RequestBody String datosJson) {
		Gson gson = new GsonBuilder().setDateFormat("DD/MM/YYYY").create();
		JsonObject jsonObject = gson.fromJson(datosJson, JsonObject.class);
		JsonArray a = (JsonArray) jsonObject.get("tipoIidentificacion");
		JsonArray b = (JsonArray) jsonObject.get("numeroIdentificacion");
		for (int i = 0; i < a.size(); i++) {
			System.out.println(a.get(i).getAsString() + "---" + b.get(i).getAsString());
		}

		JsonArray c = (JsonArray) jsonObject.get("direccion");

		for (int i = 0; i < c.size(); i++) {
			Direcion obj = new Gson().fromJson(c.get(i).getAsJsonObject().toString(), Direcion.class);
		}
		return Response.status(Status.OK).entity("hola").build();
	}

	@POST
	@RequestMapping(path = "/pruebapost/", consumes = { "application/JSON" }, produces = { "application/JSON" })
	public Response pruebapost(@RequestBody String datosJson) {
		Gson gson = new GsonBuilder().setDateFormat("DD/MM/YYYY").create();
		JsonArray lstObjetos = gson.fromJson(datosJson, JsonArray.class);

		for (int i = 0; i < lstObjetos.size(); i++) {
			ObjPrueba c = new Gson().fromJson(lstObjetos.get(i).getAsJsonObject().toString(), ObjPrueba.class);
			System.out.println(c.getTipoIidentificacion() + "--" + c.getNumeroIdentificacion() + "[ ");
			for (int j = 0; j < c.getDireccion().size(); j++) {
				System.out.println(c.getDireccion().get(j).getCiudad() + ".." + c.getDireccion().get(j).getBarrio()
						+ ".." + c.getDireccion().get(j).getDireccion());
			}
			System.out.println("]");
		}
		return Response.status(Status.OK).entity("hola").build();
	}

	@GET
	@RequestMapping(path = "/prueba", produces = { "application/JSON" })
	public Response prueba2() {
		Calendar now = Calendar.getInstance();
		System.out.println(now.getTime());
		System.out.println(now.get(Calendar.DAY_OF_MONTH));
		now.set(Calendar.MONTH, Calendar.SEPTEMBER);
		Locale locale = Locale.getDefault();
		String n = now.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, locale);
		String m = now.getDisplayName(Calendar.MONTH, Calendar.LONG, locale);
		System.out.println(n + "--" + m);
		m = now.getDisplayName(Calendar.MONTH, Calendar.LONG_FORMAT, locale);
		System.out.println(n + "--" + m);
		return Response.status(Status.OK).entity(now).build();
	}

	@POST
	@RequestMapping(path = "/pruebajwt/", consumes = { "application/JSON" }, produces = { "application/JSON" })
	public Response pruebaJWT(@RequestBody String datosJson, @RequestHeader("Authorization") String authString) {
		if (!isUserAuthenticated(authString)) {
			return Response.status(Status.FORBIDDEN).entity("{\"error\":\"User not authenticated\"}").build();
		}
		return Response.status(Status.OK).build();
	}

	private boolean isUserAuthenticated(String authString) {
		String decodedAuth = "";
		String[] authParts = authString.split("\\s+");
		String authInfo = authParts[1];
		String[] split_string = authInfo.split("\\.");
		String base64EncodedHeader = split_string[0];
		String base64EncodedBody = split_string[1];
		String base64EncodedSignature = split_string[2];

		System.out.println("~~~~~~~~~ JWT Header ~~~~~~~");
		Base64 base64Url = new Base64(true);
		String header = new String(base64Url.decode(base64EncodedHeader));
		System.out.println("JWT Header : " + header);

		System.out.println("~~~~~~~~~ JWT Body ~~~~~~~");
		String body = new String(base64Url.decode(base64EncodedBody));
		System.out.println("JWT Body : " + body);

		Gson gson = new GsonBuilder().setDateFormat("DD/MM/YYYY").create();
		JsonObject objBody = gson.fromJson(body, JsonObject.class);
		if (objBody != null) {
			if ("1234567890".equals(objBody.get("sub").getAsString())) {
				return true;
			}
		}
		return false;
	}

	@GET
	@RequestMapping(path = "/pruebapdf", produces = { "application/JSON" })
	public Response pruebapdf() {
		Locale currentLocale = Locale.getDefault();
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(currentLocale);
		// otherSymbols.setDecimalSeparator(',');
		// otherSymbols.setGroupingSeparator('.');
		DecimalFormat df = new DecimalFormat("###,###.##", otherSymbols);
		String valorFormato = "$" + StringUtils.leftPad(df.format(BigDecimal.valueOf(152000.0D).doubleValue()), 15, "");

		Object[] arguments = { "100201815", "10/10/2018", "3628993", "CED 0905481404", "GINA TERESA AYALA ALVARADO",
				valorFormato, "CUARENTA CON 57/100" + " PESOS MONEDA C/TE.", valorFormato, "$,57", "$60.00" };

		PruebaPDF p = new PruebaPDF();
		p.generarPDF(arguments);
		return Response.status(Status.OK).build();
	}

	@GET
	@RequestMapping(path = "/pruebasuma/{entero}", produces = { "application/JSON" })
	public String suma(@PathVariable("entero") Integer entero) {
		Integer total = 0;
		Date d1 = new Date();
		for (int i = 1; i <= entero; i++) {
			total += i;
		}
		Date d2 = new Date();
		System.out.println((d2.getTime() - d1.getTime()));
		d1 = new Date();
		total = (entero + 1) * (entero / 2);
		d2 = new Date();
		System.out.println((d2.getTime() - d1.getTime()));
		return "-->" + String.valueOf(total);
	}
}
