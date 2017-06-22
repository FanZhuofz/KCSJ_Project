<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page language="java" import="java.util.*" %>
<%@page language="java" import="ch04.*" %>
<%@ include file="inc/cmnAuthenticate.jsp" %>
<%
Vector vCourses = (Vector)session.getAttribute("courses");
if ( vCourses == null )
{
    vCourses = new Vector();
}
//计算总学分
int iSumPoint = 0;
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>选课结果一览</title>
<script language="JAVASCRIPT" src="common/cmnScript.js"></script>
  <script language="JAVASCRIPT" src="viewCourse.js"></script>
  <link rel="stylesheet" type="text/css" href="common\cmnStyle.css" TITLE="common"></link>

  <script language="JAVASCRIPT">
<%
    if ( session.getAttribute("errMsg") != null )
    {
%>
        var sErrMsg = "<%=session.getAttribute("errMsg")%>";
<%
    }
    else
    {
%>
        var sErrMsg = "";
<%
    }
%>
  </script>
</head>

<body>
<table border=0 cellpadding=0 cellspacing=0 height=10>
  <tr>
    <td>
      &nbsp;
    </td>
  </tr>
</table>
<form name="form_main" action="servlet/ChooseCourse" method="post" 
      onsubmit="return checkInput();" onreset="resetForm()">
<table border=0 cellpadding=0 cellspacing=2 bgcolor="#000000" align=center>
  <tr>
    <td>
      <table border=0 cellpadding=0 cellspacing=0 bgcolor="#ffffff" width=1020>
        <tr>
          <td align=left height=20>
            欢迎你，<font color=blue><%=session.getAttribute("realname")%></font>！
          </td>
          <td align=right>
            <a href="servlet/ChooseCourse">继续选课</a>
            &nbsp;| &nbsp;
            <a href="logout.jsp">退出登录</a>
            &nbsp;
          </td>
        </tr>
      </table>
    </td>
  </tr>
  <tr>
    <td>
      <table border=0 cellpadding=0 cellspacing=0 bgcolor="#ffffff" width=1020>
        <tr>
          <td>
            <br>&nbsp;&nbsp;你已经选择的课程列表如下：
          </td>
        </tr>
        <tr>
          <td height=5>
          </td>
        </tr>
        <tr>
          <td align=center height=300 valign=top>
            <table border=1 cellpadding=0 cellspacing=2 bgcolor="#ffffff" width=1000>
              <tr bgcolor=#cccccc height=18>
                <td width=50 align=center>
                  课程编号
                </td>
                <td width=250 align=center>
                  课程名称
                </td>
                <td width=50 align=center>
                  授课老师
                </td>
                <td width=40 align=center>
                  学分
                </td>
                <td width=290 align=center>
                  上课时间
                </td>
              </tr>
                
<%
for ( int i=0; i<vCourses.size(); i++ )
{
    Course course = (Course)vCourses.get(i);
    //累加总学分
    iSumPoint = iSumPoint + course.getPoint();
%>
              <tr>
                <td align=center>
                  <%=course.getCourseId()%>
                </td>
                <td>
                  <%=course.getCourseName()%>
                </td>
                <td>
                  <%=course.getTeacher()%>
                </td>
                <td align=center>
                  <%=course.getPoint()%>
                </td>
                <td align=center>
                  <%=course.getTime1Express()%>&nbsp;&nbsp;&nbsp;<%=course.getTime2Express()%>
                </td>
                
              </tr>
<%
}
%>
              
              <tr align="center">
                <td colspan=5>
                 <h3> 你当前选课的总学分为：<font color=blue>&nbsp;<%=iSumPoint%>&nbsp;</font>分。</h3>
                </td>
              </tr>
            </table>
          </td>
        </tr>
        <tr>
          <td height=10></td>
        </tr>
      </table>
    </td>
  </tr>
</table>
</form>
</body>
</html>