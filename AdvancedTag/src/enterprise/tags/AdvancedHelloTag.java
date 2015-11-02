package enterprise.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.*;

/**
 * Created by Hwang on 10/26/15.
 */
public class AdvancedHelloTag extends SimpleTagSupport {

    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();

        Calendar c = Calendar.getInstance();
        c.add(Calendar.HOUR_OF_DAY, 4);
        int h = c.get(Calendar.HOUR_OF_DAY);

        PageContext pageContext = (PageContext) getJspContext();
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        String userLocale = request.getLocale().toString();



        out.println("Current hour is " + h + " Hello " + username + " from " + userLocale);
    }
}

