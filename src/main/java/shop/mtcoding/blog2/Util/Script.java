package shop.mtcoding.blog2.Util;

public class Script {
    public static String back(String msg){
        StringBuilder sb = new StringBuilder();
        sb.append("<script>");
        sb.append("alert('"+msg+"');");
        sb.append("history.back();");
        sb.append("</script>");
        return  sb.toString();
    }
}
