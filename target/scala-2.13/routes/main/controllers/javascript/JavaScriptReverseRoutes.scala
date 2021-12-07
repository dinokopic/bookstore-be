// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:6
  class ReverseBookController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def tutorial: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BookController.tutorial",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tutorial"})
        }
      """
    )
  
    // @LINE:10
    def popular: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BookController.popular",
      """
        function(page0,size1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "books/popular" + _qS([(page0 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("page", page0)), (size1 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("size", size1))])})
        }
      """
    )
  
    // @LINE:13
    def getBookById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BookController.getBookById",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "books/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:12
    def search: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BookController.search",
      """
        function(title0,author1,genre2,numberOfAwards3,page4,size5) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "books/search" + _qS([(title0 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("title", title0)), (author1 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("author", author1)), (genre2 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("genre", genre2)), (numberOfAwards3 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("numberOfAwards", numberOfAwards3)), (page4 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("page", page4)), (size5 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("size", size5))])})
        }
      """
    )
  
    // @LINE:11
    def latest: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BookController.latest",
      """
        function(page0,size1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "books/latest" + _qS([(page0 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("page", page0)), (size1 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[Int]].javascriptUnbind + """)("size", size1))])})
        }
      """
    )
  
    // @LINE:7
    def explore: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BookController.explore",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "explore"})
        }
      """
    )
  
    // @LINE:9
    def getFilters: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BookController.getFilters",
      """
        function(type0,title1,author2,genre3,numberOfAwards4) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "books/filters/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("type", type0)) + _qS([(title1 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("title", title1)), (author2 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("author", author2)), (genre3 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("genre", genre3)), (numberOfAwards4 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("numberOfAwards", numberOfAwards4))])})
        }
      """
    )
  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BookController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:14
    def books: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BookController.books",
      """
        function(sortBy0,order1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "books" + _qS([(sortBy0 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("sortBy", sortBy0)), (order1 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("order", order1))])})
        }
      """
    )
  
  }

  // @LINE:16
  class ReverseChartController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def byPrice: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ChartController.byPrice",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "charts/price"})
        }
      """
    )
  
    // @LINE:18
    def byProfit: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ChartController.byProfit",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "charts/profit"})
        }
      """
    )
  
    // @LINE:17
    def bestSellingGenres: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ChartController.bestSellingGenres",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "charts/bestSellingGenres"})
        }
      """
    )
  
  }

  // @LINE:27
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:27
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
