
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.data._
import play.core.j.PlayFormsMagicForJava._
import scala.jdk.CollectionConverters._

object hello extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*2.2*/main("Hello")/*2.15*/ {_display_(Seq[Any](format.raw/*2.17*/("""
"""),format.raw/*3.1*/("""<section id="content">
    <div class="wrapper doc">
        <article>
            <h1>Hello """),_display_(/*6.24*/title),format.raw/*6.29*/("""!</h1>
        </article>
        <aside>
            """),_display_(/*9.14*/commonSidebar()),format.raw/*9.29*/("""
        """),format.raw/*10.9*/("""</aside>
    </div>
</section>
""")))}))
      }
    }
  }

  def render(title:String): play.twirl.api.HtmlFormat.Appendable = apply(title)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (title) => apply(title)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/hello.scala.html
                  HASH: 565652b77d141c64dcf30682bc0364f8bdf41937
                  MATRIX: 907->1|1016->18|1037->31|1076->33|1103->34|1223->128|1248->133|1329->188|1364->203|1400->212
                  LINES: 27->1|32->2|32->2|32->2|33->3|36->6|36->6|39->9|39->9|40->10
                  -- GENERATED --
              */
          