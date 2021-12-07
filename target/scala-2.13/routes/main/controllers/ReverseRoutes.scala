// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:6
  class ReverseBookController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def search(title:String = null, author:String = null, genre:String = null, numberOfAwards:String = null): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "books/search" + play.core.routing.queryString(List(if(title == null) None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("title", title)), if(author == null) None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("author", author)), if(genre == null) None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("genre", genre)), if(numberOfAwards == null) None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("numberOfAwards", numberOfAwards)))))
    }
  
    // @LINE:8
    def tutorial: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "tutorial")
    }
  
    // @LINE:10
    def popular(page:Int = 0, size:Int = 12): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "books/popular" + play.core.routing.queryString(List(if(page == 0) None else Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("page", page)), if(size == 12) None else Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("size", size)))))
    }
  
    // @LINE:13
    def getBookById(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "books/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:11
    def latest(page:Int = 0, size:Int = 12): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "books/latest" + play.core.routing.queryString(List(if(page == 0) None else Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("page", page)), if(size == 12) None else Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("size", size)))))
    }
  
    // @LINE:7
    def explore: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "explore")
    }
  
    // @LINE:9
    def getFilters(_pf_escape_type:String, title:String = null, author:String = null, genre:String = null, numberOfAwards:String = null): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "books/filters/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("type", _pf_escape_type)) + play.core.routing.queryString(List(if(title == null) None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("title", title)), if(author == null) None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("author", author)), if(genre == null) None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("genre", genre)), if(numberOfAwards == null) None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("numberOfAwards", numberOfAwards)))))
    }
  
    // @LINE:6
    def index: Call = {
      
      Call("GET", _prefix)
    }
  
    // @LINE:14
    def books(sortBy:String = null, order:String = null): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "books" + play.core.routing.queryString(List(if(sortBy == null) None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("sortBy", sortBy)), if(order == null) None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("order", order)))))
    }
  
  }

  // @LINE:16
  class ReverseChartController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def byPrice(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "charts/price")
    }
  
    // @LINE:18
    def byProfit(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "charts/profit")
    }
  
    // @LINE:17
    def bestSellingGenres(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "charts/bestSellingGenres")
    }
  
  }

  // @LINE:27
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:27
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
