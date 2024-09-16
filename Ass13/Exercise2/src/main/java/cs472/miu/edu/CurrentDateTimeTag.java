package cs472.miu.edu;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentDateTimeTag extends TagSupport {
    private String color; // Attribute for text color
    private String size;  // Attribute for font size

    // Setter method for the 'color' attribute
    public void setColor(String color) {
        this.color = color;
    }

    // Setter method for the 'size' attribute
    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            // Get the current date and time
            Date currentDate = new Date();

            // Define a date format
            SimpleDateFormat dateFormat = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
            String formattedDate = dateFormat.format(currentDate);

            // Create HTML output with the specified color and size
            String output = "<span style='color: " + color + "; font-size: " + size + ";'>" + formattedDate + "</span>";

            // Write the HTML output to the JSP page
            pageContext.getOut().write(output);
        } catch (IOException e) {
            throw new JspException(e);
        }

        // Skip the body of the tag
        return SKIP_BODY;
    }
}

