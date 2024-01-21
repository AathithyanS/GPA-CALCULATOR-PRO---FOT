package com.jpura.gpacalculatorpro.model.ict;

import java.util.ArrayList;

public class IctModules {
    public static ArrayList<TechModule> getICTSemesterModules(String department, Integer semester, String focusArea){
        ArrayList<TechModule> modules = new ArrayList<>();

        if(department.equals("Information Communication Technology") && semester.equals(1) && focusArea.equals("")){
            modules.add(new TechModule("ITC 1013 Mathematics (I) ", 3.0f));
            modules.add(new TechModule("ITC 1023 Physics for Technology ", 3.0f));
            modules.add(new TechModule("ITC 1063 Fundamentals of Programming ", 3.0f));
            modules.add(new TechModule("ITC 1032 Principles of Statistics ", 2.0f));
            modules.add(new TechModule("ITC 1052 Software Engineering (I) ", 2.0f));
            modules.add(new TechModule("ITC 1082 Communication Skills (I)/English", 2.0f));
            modules.add(new TechModule("ITC 1142 Computer Organization and Architecture ", 2.0f));
        }else if(department.equals("Information Communication Technology") && semester.equals(2) && focusArea.equals("")){
            modules.add(new TechModule("ITC 1153 Object Oriented Analysis and Design ", 3.0f));
            modules.add(new TechModule("ITC 1233 Object Oriented Programming", 3.0f));
            modules.add(new TechModule("ITC 1163 Database Systems ", 3.0f));
            modules.add(new TechModule("ITC 1102 Mathematics (II) ", 2.0f));
            modules.add(new TechModule("ITC 1112 Statistical Methods ", 2.0f));
            modules.add(new TechModule("ITC 1172 Communication Skills (II)/English ", 2.0f));
        }else if(department.equals("Information Communication Technology") && semester.equals(3) && focusArea.equals("")){
            modules.add(new TechModule("ITC 2243 Networking Essentials ", 3.0f));
            modules.add(new TechModule("ITC 2303 Visual Application Programming ", 3.0f));
            modules.add(new TechModule("ITC 2192 Mathematics for ICT ", 2.0f));
            modules.add(new TechModule("ITC 2212 Data Structures and Algorithms ", 2.0f));
            modules.add(new TechModule("ITC 2272 Operating Systems ", 2.0f));
            modules.add(new TechModule("ITC 2342 Fundamentals of Multimedia ", 2.0f));
        }else if(department.equals("Information Communication Technology") && semester.equals(4) && focusArea.equals("")){
            modules.add(new TechModule("ITC 2223 Web Application Development ", 3.0f));
            modules.add(new TechModule("ITC 2353 Introduction to Graphic Design", 3.0f));
            modules.add(new TechModule("ITC 2242 Economics and Financial Management ", 2.0f));
            modules.add(new TechModule("ITC 2252 Introduction to Machine Learning ", 2.0f));
            modules.add(new TechModule("ITC 2282 Advanced Data Structures and Algorithms", 2.0f));
            modules.add(new TechModule("ITC 2292 Digital Control Systems Technology ", 2.0f));
            modules.add(new TechModule("ITC 2302 Network Systems Design ", 2.0f));
        }else if(department.equals("Information Communication Technology") && semester.equals(5) && focusArea.equals("Multimedia Technology")){
            modules.add(new TechModule("ITC 3013 Service Oriented Architecture and Web Services ", 3.0f));
            modules.add(new TechModule("ITC 3023 Human Computer Interaction ", 3.0f));
            modules.add(new TechModule("ITM 3052 Video Production Techniques ", 2.0f));
            modules.add(new TechModule("ITM 3062 Audio Production Techniques ", 2.0f));
            modules.add(new TechModule("ITM 3232 Image Processing ", 2.0f));
            modules.add(new TechModule("ITC 3032 Literature Study and Presentation ", 2.0f));
            modules.add(new TechModule("ITC 3052 Project Management ", 2.0f));
            modules.add(new TechModule("ITC 3561 ICT Project ", 1.0f));
        }else if(department.equals("Information Communication Technology") && semester.equals(6) && focusArea.equals("Multimedia Technology")){
            modules.add(new TechModule("ITC 3093 Computer Security ", 3.0f));
            modules.add(new TechModule("ITC 3113 Software Quality Assurance ", 3.0f));
            modules.add(new TechModule("ITM 3132 3D Modeling ", 2.0f));
            modules.add(new TechModule("ITM 3072 Gaming Technology ", 2.0f));
            modules.add(new TechModule("ITM 3142 Digital Marketing", 2.0f));
            modules.add(new TechModule("ITC 3082 Research Methods and Technical Writing ", 2.0f));
            modules.add(new TechModule("ITC 3122 Mobile Application Development ", 2.0f));
        }else if(department.equals("Information Communication Technology") && semester.equals(7) && focusArea.equals("Multimedia Technology")){
            modules.add(new TechModule("ITC 4156 Industrial Training/Internship ", 6.0f));
        }else if(department.equals("Information Communication Technology") && semester.equals(8) && focusArea.equals("Multimedia Technology")){
            modules.add(new TechModule("ITC 4166 Research Project ", 6.0f));
            modules.add(new TechModule("ITM 4213 Immersive Technologies ", 3.0f));
            modules.add(new TechModule("ITM 4282 Animation Technology", 2.0f));
            modules.add(new TechModule("ITC 4172 Entrepreneurship and Small Business Management", 2.0f));
            modules.add(new TechModule("ITC 4182 Professional Practices in ICT ", 2.0f));
            modules.add(new TechModule("ITC 4212 Information Systems Strategy and IT Governance ", 2.0f));
        }else if(department.equals("Information Communication Technology") && semester.equals(5) && focusArea.equals("Network Technology")){
            modules.add(new TechModule("ITC 3013 Service Oriented Architecture and Web Services ", 3.0f));
            modules.add(new TechModule("ITC 3023 Human Computer Interaction ", 3.0f));
            modules.add(new TechModule("ITN 3043 Advanced Database Systems", 3.0f));
            modules.add(new TechModule("ITN 3052 Advanced Networking", 2.0f));
            modules.add(new TechModule("ITN 3132 Wireless Communication", 2.0f));;
            modules.add(new TechModule("ITC 3032 Literature Study and Presentation ", 2.0f));
            modules.add(new TechModule("ITC 3052 Project Management ", 2.0f));
            modules.add(new TechModule("ITC 3561 ICT Project ", 1.0f));
        }else if(department.equals("Information Communication Technology") && semester.equals(6) && focusArea.equals("Network Technology")){
            modules.add(new TechModule("ITC 3093 Computer Security ", 3.0f));
            modules.add(new TechModule("ITC 3113 Software Quality Assurance ", 3.0f));
            modules.add(new TechModule("ITN 3102 System Administration", 2.0f));
            modules.add(new TechModule("ITN 3152 Advanced Mobile Technologies", 2.0f));
            modules.add(new TechModule("ITN 3162 Distributed Networks", 2.0f));
            modules.add(new TechModule("ITC 3082 Research Methods and Technical Writing ", 2.0f));
            modules.add(new TechModule("ITC 3122 Mobile Application Development ", 2.0f));
        }else if(department.equals("Information Communication Technology") && semester.equals(7) && focusArea.equals("Network Technology")){
            modules.add(new TechModule("ITC 4156 Industrial Training/Internship ", 6.0f));
        }else if(department.equals("Information Communication Technology") && semester.equals(8) && focusArea.equals("Network Technology")){
            modules.add(new TechModule("ITC 4166 Research Project ", 6.0f));
            modules.add(new TechModule("ITN 4252 Advanced Topics in Networking ", 2.0f));
            modules.add(new TechModule("ITN 4272 Network Security", 2.0f));
            modules.add(new TechModule("ITC 4172 Entrepreneurship and Small Business Management", 2.0f));
            modules.add(new TechModule("ITC 4182 Professional Practices in ICT ", 2.0f));
            modules.add(new TechModule("ITC 4212 Information Systems Strategy and IT Governance ", 2.0f));
        }else if(department.equals("Information Communication Technology") && semester.equals(5) && focusArea.equals("Software Technology")){
            modules.add(new TechModule("ITC 3013 Service Oriented Architecture and Web Services ", 3.0f));
            modules.add(new TechModule("ITC 3023 Human Computer Interaction ", 3.0f));
            modules.add(new TechModule("ITS 3043 Advanced Database Systems", 3.0f));
            modules.add(new TechModule("ITS 3551 Software Engineering (II) ", 2.0f));
            modules.add(new TechModule("ITC 3032 Literature Study and Presentation ", 2.0f));
            modules.add(new TechModule("ITC 3052 Project Management ", 2.0f));
            modules.add(new TechModule("ITC 3561 ICT Project ", 1.0f));
        }else if(department.equals("Information Communication Technology") && semester.equals(6) && focusArea.equals("Software Technology")){
            modules.add(new TechModule("ITC 3093 Computer Security ", 3.0f));
            modules.add(new TechModule("ITC 3113 Software Quality Assurance ", 3.0f));
            modules.add(new TechModule("ITS 3173 Data Mining and Warehousing", 3.0f));
            modules.add(new TechModule("ITS 3102 System Administration", 2.0f));
            modules.add(new TechModule("ITS 3142 Software Deployment and Evolution ", 2.0f));
            modules.add(new TechModule("ITC 3082 Research Methods and Technical Writing ", 2.0f));
            modules.add(new TechModule("ITC 3122 Mobile Application Development ", 2.0f));
        }else if(department.equals("Information Communication Technology") && semester.equals(7) && focusArea.equals("Software Technology")){
            modules.add(new TechModule("ITC 4156 Industrial Training/Internship ", 6.0f));
        }else if(department.equals("Information Communication Technology") && semester.equals(8) && focusArea.equals("Software Technology")){
            modules.add(new TechModule("ITC 4166 Research Project ", 6.0f));
            modules.add(new TechModule("ITS 4243 Microservices and Cloud Computing ", 3.0f));
            modules.add(new TechModule("ITS 4202 Emerging Technologies", 2.0f));
            modules.add(new TechModule("ITC 4172 Entrepreneurship and Small Business Management", 2.0f));
            modules.add(new TechModule("ITC 4182 Professional Practices in ICT ", 2.0f));
            modules.add(new TechModule("ITC 4212 Information Systems Strategy and IT Governance ", 2.0f));
        }

        return modules;
    }
}
