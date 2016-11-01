/**
 * 
 */
package com.krustykrab.app;

import javax.persistence.EntityManagerFactory;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import com.krustykrab.hibernate.JpaUtil;

/**
 * @author Vladislav Zedano
 *
 */
@SpringBootConfiguration
public class KrustyKrabConfiguration
{
	@Bean
	public EntityManagerFactory emf(){
		return JpaUtil.getEmf();
	}
}
