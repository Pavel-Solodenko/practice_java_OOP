import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class Client implements Runnable{
	private String ansv;
	private Socket soc;
	private Thread t;
	private Group group;
	
	public Client(Socket soc,String ansv,Group group) {
		this.soc = soc;
		this.ansv = ansv;
		this.group = group;
		t = new Thread(this);
		t.start();
	}
	
	@Override
	public void run() {
		try (InputStream is = soc.getInputStream();OutputStream os = soc.getOutputStream()) {
			PrintWriter pw = new PrintWriter(os);
			byte[] buffer = new byte[is.available()];
			is.read(buffer);
			String to_do = selectResponse(new String(buffer));
			if (!to_do.isEmpty()) {
				if (!to_do.contains("?")) {
					ansv = to_do(to_do);
				}
				else {
					String method = to_do.substring(0,to_do.indexOf("?"));
					invokeMethod(getParamFromReferer(to_do.substring(to_do.indexOf("?")+1)),group,method);
				}
			}
			String response = "HTTP/1.1 200 OK\r\n" + "Server: My_Server\r\n"+"Content-type:text/html\r\n"+
			"Content-length: "+"\r\n" + "Connection: close\r\n\r\n";
			pw.print(response+ansv);
			pw.flush();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String selectResponse(String str) {
		if (str.indexOf("Referer") > 0) {
			String response = str.substring(str.indexOf("Referer"),str.indexOf("Accept-Encoding"));
			response = response.replaceAll("\r\n", "");
			response = response.substring(response.lastIndexOf("/")+1);
			return response;
		}
		return "";
	}
	
	private String to_do(String name) {
		String ansver = "";
		boolean not_param = false;
		ArrayList<Class<?>> types_param_constructor = new ArrayList<Class<?>>();
		ArrayList<Field> fields_names = new ArrayList<Field>();
		Method[] methods = Group.class.getDeclaredMethods();
		for (int i = 0;i < methods.length;++i) {
			if (name.equals(methods[i].getName())) {
				Class<?>[] cls= methods[i].getParameterTypes();
				if (cls.length == 0 /*&& methods[i].getName().equals("toString")*/) {
					not_param = true;
					break;
				}
				int n = 1;
				for (int a = 0;a < cls.length;++a) {
					String t_name = cls[a].getName();
					//check primitive type of variable in such method
					if (t_name.equals("int") || t_name.equals("java.lang.String") || t_name.equals("char")) {
						ansver += "<html><head><title>Interface group</title><meta charset='utf-8'></head><body><form method=\"get\">";
						if (t_name.equals("int")) {
							ansver += "<p><input maxlength=\"2\" name=\""+"simleParam"+n+"\"></p>";
						}
						if (t_name.equals("char")) {
							ansver += "<p><input maxlength=\"1\" name=\""+"simleParam"+n+"\"></p>";
						}
						if (t_name.equals("java.lang.String")) {
							ansver += "<p><input maxlength=\"15\" name=\""+"simleParam"+n+"\"></p>";
						}
						n++;
					}
					else {
						Field[] fi =cls[a].getDeclaredFields();
						for (int j = 0; j < fi.length;++j) {
							fields_names.add(fi[j]);
						}
						Constructor[] con = cls[a].getDeclaredConstructors();
						Class<?>[] cl = con[0].getParameterTypes();
						for (int k = 0;k<cl.length;++k) {
							types_param_constructor.add(cl[k]);
						}
					}
				}
			}
		}
		if (!ansver.isEmpty()) {
			ansver += "<p>" + "<input type=\"submit\">" +"</p></form>"+
					"<form><button><a href=\"http://127.0.0.1:8080\">Menu</a></button></form>"
					+"</form></body></html>";
			return ansver;
		}
		if (not_param == true) {
			ansver += "<html><head><title>Interface group</title><meta charset='utf-8'></head><body><form method=\"get\">"+
			"<button>Continue</button></form>"
			+"<form><button><a href=\"http://127.0.0.1:8080\">Menu</a></button></form>"+"</form></body></html>";
			return ansver;
		}
		
		ansver += "<html><head><title>Interface group</title><meta charset='utf-8'></head><body><form method=\"get\">";
		Iterator<Field> itr_fields = fields_names.iterator();
		Iterator<Class<?>> itr_param_con = types_param_constructor.iterator();
		while(itr_fields.hasNext()) {
			Field temp_f = itr_fields.next();
			String temp = temp_f.getName();
			String name_f = temp_f.getType().getName();
			if (name_f.equals(itr_param_con.next().getName()) && 
			   (name_f.equals("int") || name_f.equals("char"))) {
				if (name_f.equals("int")) {
					ansver += "<p> "+temp+"</p>";
					ansver += "<p><input maxlength=\"2\" name=\""+temp+"\"></p>";
				}
				if (name_f.equals("char")) {
					ansver += "<p> "+temp+"</p>";
					ansver += "<p><input maxlength=\"1\" name=\""+temp+"\"></p>";
				}
			}
			else {
				ansver += "<p> "+temp+"</p>";
				ansver += "<p><input maxlength=\"15\" name=\""+temp+"\"></p>";
			}
		}
		ansver += "<p>" + "<input type=\"submit\">" +"</p></form>"+
		"<form><button><a href=\"http://127.0.0.1:8080\">Menu</a></button></form>"
		+"</form></body></html>";
		return ansver;
	}
	
	private ArrayList<String> getParamFromReferer(String referer) {
		ArrayList<String> parameters = new ArrayList<String>();
		while (!referer.isEmpty()) {
			try {
				String temp = referer.substring(referer.indexOf("=")+1,referer.indexOf("&"));
				referer = referer.substring(referer.indexOf("&")+1);
				parameters.add(temp);
			}
			catch (Exception e) {
				break;
			}
		}
		parameters.add(referer.substring(referer.lastIndexOf("=")+1));
		return parameters;
	}
	
	private void invokeMethod(ArrayList<String> parameters,Group group,String method) {
		String ansver = "";
		Class<?> cls_group = group.getClass();
		Method[] group_meth = cls_group.getMethods();
		Method method_inv = null;
		for (int i = 0; i < group_meth.length;++i) {
			if (group_meth[i].getName().equals(method)) {
				method_inv = group_meth[i];
				break;
			}
		}
		Class<?>[] method_param = method_inv.getParameterTypes();
			boolean parameters_empty = false;
			if (parameters.size() == 1 && parameters.get(0).isEmpty()) {
				parameters_empty = true;
			}
			if (method_param.length != parameters.size() && parameters_empty != true) {
				Constructor<?>[] con = method_param[0].getConstructors();
				try {
				Object obj = (Object) con[1].newInstance(parameters);
				method_inv.invoke(group, obj);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
/*				for (Class<?> a : cls) {
					String temp = itr_param.next();
					if (!a.getName().equals(temp.getClass().getName())) {
						byte[] ar = temp.getBytes();
						char[] ap = new char[ar.length];
						for (int k = 0;k < ar.length;k++) {
							ap[k] = (char)ar[k];
						}
					}
				}
*/			}
			else {
				try {
					if (parameters_empty == true && method_inv.getReturnType() != null) {
						Object obj = method_inv.invoke(group);
						ansver +="<html><head><title>Interface group</title><meta charset='utf-8'></head><body>"
								+"<p>"+obj.toString()+"</p>"
								+"<form><button><a href=\"http://127.0.0.1:8080\">Menu</a></button></form>"
								+"</body></html>";
						ansver = ansver.replaceAll("\r", "<p>");
						ansver = ansver.replaceAll("\n", "</p>");
						ansver = ansver.replaceAll(",","");
						this.ansv = ansver;
					}
					if (method_inv.getReturnType()!= null && parameters_empty == false) {
						Object obj = method_inv.invoke(group, parameters.get(0));
						if (obj != null) {
							ansver += "<html><head><title>Interface group</title><meta charset='utf-8'></head><body>"
									+"<p>"+obj.toString()+"</p>"
									+"<form><button><a href=\"http://127.0.0.1:8080\">Menu</a></button></form>"
									+"</body></html>";
							this.ansv = ansver;
						}
						else {
							ansver += "<html><head><title>Interface group</title><meta charset='utf-8'></head><body>"
									+"<p>"+"Not found"+"</p>"
									+"<form><button><a href=\"http://127.0.0.1:8080\">Menu</a></button></form>"
									+"</body></html>";
							this.ansv = ansver;
						}
					}
					else {
						if (parameters_empty == false) {
							method_inv.invoke(group, parameters.get(0));
						}
					}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
	}
	
}
