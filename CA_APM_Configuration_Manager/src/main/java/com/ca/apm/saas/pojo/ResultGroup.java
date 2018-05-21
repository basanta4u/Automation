package com.ca.apm.saas.pojo;

import java.util.List;

/*
 * Author: Bassanta Kumar Dwibedy(dwiba01@ca.com)
 * 
 * Copyright (c) 2017 CA. All rights reserved.
 * 
 * This software and all information contained therein is confidential and
 * proprietary and shall not be duplicated, used, disclosed or disseminated in
 * any way except as authorized by the applicable license agreement, without
 * the express written permission of CA. All authorized reproductions must be
 * marked with this language.
 * 
 * EXCEPT AS SET FORTH IN THE APPLICABLE LICENSE AGREEMENT, TO THE EXTENT
 * PERMITTED BY APPLICABLE LAW, CA PROVIDES THIS SOFTWARE WITHOUT WARRANTY OF
 * ANY KIND, INCLUDING WITHOUT LIMITATION, ANY IMPLIED WARRANTIES OF
 * MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE. IN NO EVENT WILL CA BE
 * LIABLE TO THE END USER OR ANY THIRD PARTY FOR ANY LOSS OR DAMAGE, DIRECT OR
 * INDIRECT, FROM THE USE OF THIS SOFTWARE, INCLUDING WITHOUT LIMITATION, LOST
 * PROFITS, BUSINESS INTERRUPTION, GOODWILL, OR LOST DATA, EVEN IF CA IS
 * EXPRESSLY ADVISED OF SUCH LOSS OR DAMAGE.
 */

public class ResultGroup {

   

    public ResultGroup() {

    }

  
    private String validationPoint;
     private List<Long> listResponseTime;
    private List<String> listexeTime;
 
    public String getValidationPoint() {
        return validationPoint;
    }

    public void setValidationPoint(String validationPoint) {
        this.validationPoint = validationPoint;
    }

	

	public List<Long> getListResponseTime() {
		return listResponseTime;
	}

	public void setListResponseTime(List<Long> listResponseTime) {
		this.listResponseTime = listResponseTime;
	}

	public List<String> getListexeTime() {
		return listexeTime;
	}

	public void setListexeTime(List<String> listexeTime) {
		this.listexeTime = listexeTime;
	}

	

}
