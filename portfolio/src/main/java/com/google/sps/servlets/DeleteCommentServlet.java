package com.google.sps.servlets;

import static com.google.sps.data.Keys.COMMENT_ENTITY;
import static com.google.sps.data.Keys.ID_ENTITY_PROPERTY;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete-comment")
public class DeleteCommentServlet extends HttpServlet {
  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    datastore.delete(KeyFactory.createKey(
        COMMENT_ENTITY, Long.parseLong(request.getParameter(ID_ENTITY_PROPERTY))));
  }
}