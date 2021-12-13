// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  BookController_1: controllers.BookController,
  // @LINE:16
  ChartController_0: controllers.ChartController,
  // @LINE:28
  Assets_2: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    BookController_1: controllers.BookController,
    // @LINE:16
    ChartController_0: controllers.ChartController,
    // @LINE:28
    Assets_2: controllers.Assets
  ) = this(errorHandler, BookController_1, ChartController_0, Assets_2, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, BookController_1, ChartController_0, Assets_2, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.BookController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """explore""", """controllers.BookController.explore"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tutorial""", """controllers.BookController.tutorial"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """books/filters/""" + "$" + """type<[^/]+>""", """controllers.BookController.getFilters(type:String, title:String ?= null, author:String ?= null, genre:String ?= null, numberOfAwards:String ?= null)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """books/popular""", """controllers.BookController.popular(page:Int ?= 0, size:Int ?= 12)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """books/latest""", """controllers.BookController.latest(page:Int ?= 0, size:Int ?= 12)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """books/search""", """controllers.BookController.search(title:String ?= null, author:String ?= null, genre:String ?= null, numberOfAwards:String ?= null, page:Int ?= 0, size:Int ?= 12)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """books/""" + "$" + """id<[^/]+>""", """controllers.BookController.getBookById(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """books""", """controllers.BookController.books(sortBy:String ?= null, order:String ?= null)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """charts/price""", """controllers.ChartController.byPrice()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """charts/bestSellingGenres""", """controllers.ChartController.bestSellingGenres()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """charts/profit""", """controllers.ChartController.byProfit()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """charts/bestSellingBooks""", """controllers.ChartController.bestSellingBooks()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_BookController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_BookController_index0_invoker = createInvoker(
    BookController_1.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BookController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_BookController_explore1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("explore")))
  )
  private[this] lazy val controllers_BookController_explore1_invoker = createInvoker(
    BookController_1.explore,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BookController",
      "explore",
      Nil,
      "GET",
      this.prefix + """explore""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_BookController_tutorial2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tutorial")))
  )
  private[this] lazy val controllers_BookController_tutorial2_invoker = createInvoker(
    BookController_1.tutorial,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BookController",
      "tutorial",
      Nil,
      "GET",
      this.prefix + """tutorial""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_BookController_getFilters3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("books/filters/"), DynamicPart("type", """[^/]+""",true)))
  )
  private[this] lazy val controllers_BookController_getFilters3_invoker = createInvoker(
    BookController_1.getFilters(fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BookController",
      "getFilters",
      Seq(classOf[String], classOf[String], classOf[String], classOf[String], classOf[String]),
      "GET",
      this.prefix + """books/filters/""" + "$" + """type<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_BookController_popular4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("books/popular")))
  )
  private[this] lazy val controllers_BookController_popular4_invoker = createInvoker(
    BookController_1.popular(fakeValue[Int], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BookController",
      "popular",
      Seq(classOf[Int], classOf[Int]),
      "GET",
      this.prefix + """books/popular""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_BookController_latest5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("books/latest")))
  )
  private[this] lazy val controllers_BookController_latest5_invoker = createInvoker(
    BookController_1.latest(fakeValue[Int], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BookController",
      "latest",
      Seq(classOf[Int], classOf[Int]),
      "GET",
      this.prefix + """books/latest""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_BookController_search6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("books/search")))
  )
  private[this] lazy val controllers_BookController_search6_invoker = createInvoker(
    BookController_1.search(fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[Int], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BookController",
      "search",
      Seq(classOf[String], classOf[String], classOf[String], classOf[String], classOf[Int], classOf[Int]),
      "GET",
      this.prefix + """books/search""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_BookController_getBookById7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("books/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_BookController_getBookById7_invoker = createInvoker(
    BookController_1.getBookById(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BookController",
      "getBookById",
      Seq(classOf[String]),
      "GET",
      this.prefix + """books/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_BookController_books8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("books")))
  )
  private[this] lazy val controllers_BookController_books8_invoker = createInvoker(
    BookController_1.books(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BookController",
      "books",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """books""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_ChartController_byPrice9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("charts/price")))
  )
  private[this] lazy val controllers_ChartController_byPrice9_invoker = createInvoker(
    ChartController_0.byPrice(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ChartController",
      "byPrice",
      Nil,
      "GET",
      this.prefix + """charts/price""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_ChartController_bestSellingGenres10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("charts/bestSellingGenres")))
  )
  private[this] lazy val controllers_ChartController_bestSellingGenres10_invoker = createInvoker(
    ChartController_0.bestSellingGenres(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ChartController",
      "bestSellingGenres",
      Nil,
      "GET",
      this.prefix + """charts/bestSellingGenres""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_ChartController_byProfit11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("charts/profit")))
  )
  private[this] lazy val controllers_ChartController_byProfit11_invoker = createInvoker(
    ChartController_0.byProfit(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ChartController",
      "byProfit",
      Nil,
      "GET",
      this.prefix + """charts/profit""",
      """""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_ChartController_bestSellingBooks12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("charts/bestSellingBooks")))
  )
  private[this] lazy val controllers_ChartController_bestSellingBooks12_invoker = createInvoker(
    ChartController_0.bestSellingBooks(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ChartController",
      "bestSellingBooks",
      Nil,
      "GET",
      this.prefix + """charts/bestSellingBooks""",
      """""",
      Seq()
    )
  )

  // @LINE:28
  private[this] lazy val controllers_Assets_versioned13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned13_invoker = createInvoker(
    Assets_2.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_BookController_index0_route(params@_) =>
      call { 
        controllers_BookController_index0_invoker.call(BookController_1.index)
      }
  
    // @LINE:7
    case controllers_BookController_explore1_route(params@_) =>
      call { 
        controllers_BookController_explore1_invoker.call(BookController_1.explore)
      }
  
    // @LINE:8
    case controllers_BookController_tutorial2_route(params@_) =>
      call { 
        controllers_BookController_tutorial2_invoker.call(BookController_1.tutorial)
      }
  
    // @LINE:9
    case controllers_BookController_getFilters3_route(params@_) =>
      call(params.fromPath[String]("type", None), params.fromQuery[String]("title", Some(null)), params.fromQuery[String]("author", Some(null)), params.fromQuery[String]("genre", Some(null)), params.fromQuery[String]("numberOfAwards", Some(null))) { (_pf_escape_type, title, author, genre, numberOfAwards) =>
        controllers_BookController_getFilters3_invoker.call(BookController_1.getFilters(_pf_escape_type, title, author, genre, numberOfAwards))
      }
  
    // @LINE:10
    case controllers_BookController_popular4_route(params@_) =>
      call(params.fromQuery[Int]("page", Some(0)), params.fromQuery[Int]("size", Some(12))) { (page, size) =>
        controllers_BookController_popular4_invoker.call(BookController_1.popular(page, size))
      }
  
    // @LINE:11
    case controllers_BookController_latest5_route(params@_) =>
      call(params.fromQuery[Int]("page", Some(0)), params.fromQuery[Int]("size", Some(12))) { (page, size) =>
        controllers_BookController_latest5_invoker.call(BookController_1.latest(page, size))
      }
  
    // @LINE:12
    case controllers_BookController_search6_route(params@_) =>
      call(params.fromQuery[String]("title", Some(null)), params.fromQuery[String]("author", Some(null)), params.fromQuery[String]("genre", Some(null)), params.fromQuery[String]("numberOfAwards", Some(null)), params.fromQuery[Int]("page", Some(0)), params.fromQuery[Int]("size", Some(12))) { (title, author, genre, numberOfAwards, page, size) =>
        controllers_BookController_search6_invoker.call(BookController_1.search(title, author, genre, numberOfAwards, page, size))
      }
  
    // @LINE:13
    case controllers_BookController_getBookById7_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_BookController_getBookById7_invoker.call(BookController_1.getBookById(id))
      }
  
    // @LINE:14
    case controllers_BookController_books8_route(params@_) =>
      call(params.fromQuery[String]("sortBy", Some(null)), params.fromQuery[String]("order", Some(null))) { (sortBy, order) =>
        controllers_BookController_books8_invoker.call(BookController_1.books(sortBy, order))
      }
  
    // @LINE:16
    case controllers_ChartController_byPrice9_route(params@_) =>
      call { 
        controllers_ChartController_byPrice9_invoker.call(ChartController_0.byPrice())
      }
  
    // @LINE:17
    case controllers_ChartController_bestSellingGenres10_route(params@_) =>
      call { 
        controllers_ChartController_bestSellingGenres10_invoker.call(ChartController_0.bestSellingGenres())
      }
  
    // @LINE:18
    case controllers_ChartController_byProfit11_route(params@_) =>
      call { 
        controllers_ChartController_byProfit11_invoker.call(ChartController_0.byProfit())
      }
  
    // @LINE:19
    case controllers_ChartController_bestSellingBooks12_route(params@_) =>
      call { 
        controllers_ChartController_bestSellingBooks12_invoker.call(ChartController_0.bestSellingBooks())
      }
  
    // @LINE:28
    case controllers_Assets_versioned13_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned13_invoker.call(Assets_2.versioned(path, file))
      }
  }
}
