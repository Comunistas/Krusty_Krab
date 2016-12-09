/**
 * 
 */
package com.krustykrab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Vladislav Zedano
 *
 */
@Data
@AllArgsConstructor
public class SuccessResponse
{
	private boolean success;
	
	public SuccessResponse(){
		success = true;
	}
}
