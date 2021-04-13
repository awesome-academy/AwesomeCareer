package com.aa.awesomecareer.model;

import java.util.Map;

public class MailModel {

    public static class HtmlTemplate {
        private String template;
        private Map<String, Object> props;

        public String getTemplate() {
			return template;
		}
		public void setTemplate(String template) {
			this.template = template;
		}
		public Map<String, Object> getProps() {
			return props;
		}
		public void setProps(Map<String, Object> props) {
			this.props = props;
		}

		public HtmlTemplate(String template, Map<String, Object> props) {
            this.template = template;
            this.props = props;
        }
    }

    private String from;
    private String to;
    private String subject;
    private HtmlTemplate htmlTemplate;
    
	public MailModel() {
		
	}
	
	public MailModel(String from, String to, String subject, HtmlTemplate htmlTemplate) {
		super();
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.htmlTemplate = htmlTemplate;
	}

	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public HtmlTemplate getHtmlTemplate() {
		return htmlTemplate;
	}
	public void setHtmlTemplate(HtmlTemplate htmlTemplate) {
		this.htmlTemplate = htmlTemplate;
	}

}
