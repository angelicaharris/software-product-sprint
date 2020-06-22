// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet that returns some example content. TODO: modify this file to handle comments data */
@WebServlet("/data")
public class DataServlet extends HttpServlet {



  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
 Query query = new Query("Task").addSort("timestamp", SortDirection.DESCENDING);


    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    PreparedQuery results = datastore.prepare(query);


ArrayList<String> nums = new ArrayList<String>();
nums.add("One");
nums.add("Two");
nums.add("Three");

    log("Raw ArrayList ===> " + nums);
 
		// Use this builder to construct a Gson instance when you need to set configuration options other than the default.
		GsonBuilder gsonBuilder = new GsonBuilder();
		
		// This is the main class for using Gson. Gson is typically used by first constructing a Gson instance and then invoking toJson(Object) or fromJson(String, Class) methods on it. 
		// Gson instances are Thread-safe so you can reuse them freely across multiple threads.
		Gson gson = gsonBuilder.create();
 
		String JSONObject = gson.toJson(nums);
		log("\nConverted JSONObject ==> " + JSONObject);
		
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		String prettyJson = prettyGson.toJson(nums);
		
		log("\nPretty JSONObject ==> " + prettyJson);
        

    response.setContentType("text/html;");
    response.getWriter().println("<h1>Hello Angelica!</h1>");
    	 
      
  }
 




}
