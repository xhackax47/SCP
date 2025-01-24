package com.scp.foundation.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SCP {
	    @Id 
	    private Long id;
	    private String name;
	    private String description;
	    
		public SCP(String name, String description) {
			super();
			this.name = name;
			this.description = description;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
		   
}
