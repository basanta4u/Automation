package com.ca.apm.saas.pojo;


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

public class Result {

    public Result(String vp, boolean b, long l, int i) {
        // TODO Auto-generated constructor stub
        this.validationPoint = vp;
        this.result = b;
        this.responseTime = l;
        this.axaValues = i;
    }

    public Result() {

    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(long responseTime) {
        this.responseTime = responseTime;
    }

    public long getAxaValues() {
        return axaValues;
    }

    public void setAxaValues(long axaValues) {
        this.axaValues = axaValues;
    }

    private String validationPoint;
    private boolean result = false;
    private long responseTime = -1;
    private long axaValues = -1;
    
    private String exeTime;
    

    public String getValidationPoint() {
        return validationPoint;
    }

    public void setValidationPoint(String validationPoint) {
        this.validationPoint = validationPoint;
    }

	public String getExeTime() {
		return exeTime;
	}

	public void setExeTime(String exeTime) {
		this.exeTime = exeTime;
	}

	

	

}
