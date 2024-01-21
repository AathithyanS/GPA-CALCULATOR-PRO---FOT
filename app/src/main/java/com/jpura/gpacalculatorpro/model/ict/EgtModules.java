package com.jpura.gpacalculatorpro.model.ict;

import java.util.ArrayList;

public class EgtModules {

    public static ArrayList<TechModule> getEgtSemesterModules(String department, Integer semester, String focusArea){
        ArrayList<TechModule> modules = new ArrayList<>();
    /*----------------------------------------------------------------------------------------------------
     * Engineering Technology all semester modules and focus areas
     -----------------------------------------------------------------------------------------------------*/
        // first semster
        if(department.equals("Engineering Technology") && semester.equals(1) && focusArea.equals("")){
            modules.add(new TechModule("Mathematics (I)",3.0f));
            modules.add(new TechModule("Physics for Technology",3.0f));
            modules.add(new TechModule("Chemistry for Technology ",2.0f));
            modules.add(new TechModule("Engineering Drawing ",2.0f));
            modules.add(new TechModule("Principles of Statistics ",2.0f));
            modules.add(new TechModule("Computing for Technology ",2.0f));
            modules.add(new TechModule("Communication Skills (I)/English ",2.0f));
        }
        // second semester  -------------------------------------------------------------------------------
        else if(department.equals("Engineering Technology") && semester.equals(2) && focusArea.equals("")){
            modules.add(new TechModule("Mechanics",3.0f));
            modules.add(new TechModule("Basic Manufacturing Processes ",3.0f));
            modules.add(new TechModule("Mathematics (II) ",2.0f));
            modules.add(new TechModule("Statistical Methods ",2.0f));
            modules.add(new TechModule("Introduction to Computer Programming ",2.0f));
            modules.add(new TechModule("Theory of Electricity",2.0f));
            modules.add(new TechModule("Properties of Materials ",2.0f));
            modules.add(new TechModule("Communication Skills (II)/English ",2.0f));
        }
        // Construction and Building Services Technology 3rd semester--------------
        else if(department.equals("Engineering Technology") && semester.equals(3) && focusArea.equals("Construction and Building Services Technology")){
            modules.add(new TechModule("Thermodynamics ",3.0f));
            modules.add(new TechModule("Mathematics (III) ",2.0f));
            modules.add(new TechModule("Economics and Financial Management",2.0f));
            modules.add(new TechModule("Measurements and Instrumentation",2.0f));
            modules.add(new TechModule("Manufacturing Technology",2.0f));
            modules.add(new TechModule("Construction Materials and Methods", 2.0f));
            modules.add(new TechModule("Building Services",2.0f));
            modules.add(new TechModule("Quantity Surveying Practice I ",2.0f));
        }
        //Construction and Building Services Technology 4th semester--------------
        else if(department.equals("Engineering Technology") && semester.equals(4) && focusArea.equals("Construction and Building Services Technology")){
            modules.add(new TechModule("Soils & Earth Works",3.0f));
            modules.add(new TechModule("Surveying ",3.0f));
            modules.add(new TechModule("CADD Software Applications ",2.0f));
            modules.add(new TechModule("Quantity Surveying Practice II ",2.0f));
            modules.add(new TechModule("Building Economics ",2.0f));
            modules.add(new TechModule("Numerical Methods ",2.0f));
            modules.add(new TechModule("Fluid Mechanics ",2.0f));
            modules.add(new TechModule("Building Services and Management",2.0f));
        }
        //Construction and Building Services Technology 5th semester--------------
        else if(department.equals("Engineering Technology") && semester.equals(5) && focusArea.equals("Construction and Building Services Technology")){
            modules.add(new TechModule("Structural Systems ",3.0f));
            modules.add(new TechModule("Mechanics of Materials ",3.0f));
            modules.add(new TechModule("Transportation and Highway Engineering ",3.0f));
            modules.add(new TechModule("Principles of Quality Management ",2.0f));
            modules.add(new TechModule("Research Methodology ",1.0f));
            modules.add(new TechModule("Occupational Health and Safety ",1.0f));
            modules.add(new TechModule("Construction Codes and Regulations",1.0f));
        }
        //Construction and Building Services Technology 6th semester--------------
        else if(department.equals("Engineering Technology") && semester.equals(6) && focusArea.equals("Construction and Building Services Technology")){
            modules.add(new TechModule("Industrial Training/Internship",6.0f));
        }
        //Construction and Building Services Technology 7th semester--------------
        else if(department.equals("Engineering Technology") && semester.equals(7) && focusArea.equals("Construction and Building Services Technology")){
            modules.add(new TechModule("Civil Engineering Construction Technologies ",3.0f));
            modules.add(new TechModule("Construction Estimation and Procurement ",3.0f));
            modules.add(new TechModule("Project Management",2.0f));
            modules.add(new TechModule("Energy Management ",2.0f));
            modules.add(new TechModule("Urban Planning, Sustainable Building Design and Construction ",2.0f));
            modules.add(new TechModule("Building Maintenance and Management ",2.0f));
        }
        //Construction and Building Services Technology 8th semester--------------
        else if(department.equals("Engineering Technology") && semester.equals(8) && focusArea.equals("Construction and Building Services Technology")){
            modules.add(new TechModule("Research Project ",6.0f));//this is beging from 7th semester...
            modules.add(new TechModule("Building Instrumentation and Automation ",2.0f));
            modules.add(new TechModule("Contract Law and Dispute Resolution",2.0f));
            modules.add(new TechModule("Entrepreneurship and Small Business Management ",1.0f));
            modules.add(new TechModule("Intellectual Property Rights and Policies ",1.0f));
        }
        //Energy and Environmental Technology 3rd semester-------------------------------------------------------------------------------
        else if(department.equals("Engineering Technology") && semester.equals(3) && focusArea.equals("Energy and Environmental Technology")){
            modules.add(new TechModule("Thermodynamics ",3.0f));
            modules.add(new TechModule("Mathematics (III)",2.0f));
            modules.add(new TechModule("Economics and Financial Management ",2.0f));
            modules.add(new TechModule("Measurements and Instrumentation ",2.0f));
            modules.add(new TechModule("Manufacturing Technology ",2.0f));
            modules.add(new TechModule("Applied Electronics ",2.0f));
            modules.add(new TechModule("Polymer Technology ",2.0f));
            modules.add(new TechModule("Principles of Environmental Chemistry ",2.0f));
            modules.add(new TechModule("Introduction to Environmental Technology ",1.0f));
            modules.add(new TechModule("Non-renewable Energy Systems Technology ",1.0f));
        }
        //Energy and Environmental Technology 4th semester-------------------------------------------------------------------------------
        else if(department.equals("Engineering Technology") && semester.equals(4) && focusArea.equals("Energy and Environmental Technology")){
            modules.add(new TechModule("CADD Software Applications ",2.0f));
            modules.add(new TechModule("Numerical Methods ",2.0f));
            modules.add(new TechModule("Fluid Mechanics ",2.0f));
            modules.add(new TechModule("Solid and Hazardous Waste Management Technology ",2.0f));
            modules.add(new TechModule("Energy Efficiency and Conservation Techniques ",2.0f));
            modules.add(new TechModule("Power System ",2.0f));
            modules.add(new TechModule("Plant Design and Process Control",2.0f));
            modules.add(new TechModule("Environmental Data Analysis ",1.0f));
            modules.add(new TechModule("Renewable Energy Systems Technology ",2.0f));
            modules.add(new TechModule("Energy Storage Devices",2.0f));
        }
        //Energy and Environmental Technology 5th semester-------------------------------------------------------
        else if(department.equals("Engineering Technology") && semester.equals(5) && focusArea.equals("Energy and Environmental Technology")){
            modules.add(new TechModule("Mechanics of Materials ",3.0f));
            modules.add(new TechModule("Principles of Quality Management ",2.0f));
            modules.add(new TechModule("Energy auditing ",2.0f));
            modules.add(new TechModule("Water and Wastewater Treatment Technology ",2.0f));
            modules.add(new TechModule("Air Pollution Control Technology ",2.0f));
            modules.add(new TechModule("Research Methodology ",1.0f));
            modules.add(new TechModule("Occupational Health and Safety ",1.0f));
            modules.add(new TechModule("Boiler installation, Operation, and Maintenance Technology ",1.0f));
        }
        //Energy and Environmental Technology 6th semester-------------------------------------------------------
        else if(department.equals("Engineering Technology") && semester.equals(6) && focusArea.equals("Energy and Environmental Technology")){
            modules.add(new TechModule("Industrial Training/Internship",6.0f));
        }
        //Energy and Environmental Technology 7th semester-------------------------------------------------------
        else if(department.equals("Engineering Technology") && semester.equals(7) && focusArea.equals("Energy and Environmental Technology")){
            modules.add(new TechModule("Project Management ",2.0f));
            modules.add(new TechModule("Urban Design and Green Building Technology ",1.0f));
            modules.add(new TechModule("Cleaner Production and Green Technologies ",1.0f));
            modules.add(new TechModule("Greenhouse Gas Accounting ",1.0f));
            modules.add(new TechModule("Environmental Law, Policy and Education ",1.0f));
            modules.add(new TechModule("Wind Energy Technology ",1.0f));
            modules.add(new TechModule("Biomass and Biofuel Energy Technology ",1.0f));
            modules.add(new TechModule("Environmental Remediation Technology ",1.0f));
            modules.add(new TechModule("Ocean Energy Technology ",1.0f));
        }
        //Energy and Environmental Technology 8th semester----------------------------------------------------
        else if(department.equals("Engineering Technology") && semester.equals(8) && focusArea.equals("Energy and Environmental Technology")){
            modules.add(new TechModule("Research and Design Project ",6.0f));// this is also beging from 7th semester
            modules.add(new TechModule("Entrepreneurship and Small Business Management ",1.0f));
            modules.add(new TechModule("Intellectual Property Rights and Policies ",1.0f));
            modules.add(new TechModule("Environmental Assessments and Sustainable Planning ",1.0f));
            modules.add(new TechModule("Environmental Economics ",1.0f));
            modules.add(new TechModule("Industrial Ecology and Circular Economy ",1.0f));
            modules.add(new TechModule("Hazard identification and Risk Assessments",1.0f));
        }
        //Geotechnology 3rd semester-------------------------------------------------------
        else if(department.equals("Engineering Technology") && semester.equals(3) && focusArea.equals("Geotechnology")){
            modules.add(new TechModule("Introduction to Geology ",3.0f));
            modules.add(new TechModule("Mathematics (III) ",2.0f));
            modules.add(new TechModule("Economics and Financial Management ",2.0f));
            modules.add(new TechModule("Measurement and Instrumentation ",2.0f));
            modules.add(new TechModule("Introduction to Mechanics of Materials ",2.0f));
            modules.add(new TechModule("Construction Material and Methods ",2.0f));
            modules.add(new TechModule("Introduction to Applied Geophysics ",2.0f));
            modules.add(new TechModule("Introduction to Applied Geophysics ",2.0f));
        }
        //Geotechnology 4th semester-------------------------------------------------------
        else if(department.equals("Engineering Technology") && semester.equals(4) && focusArea.equals("Geotechnology")){
            modules.add(new TechModule("Surveying ",3.0f));
            modules.add(new TechModule("CADD Software Applications ",2.0f));
            modules.add(new TechModule("Materials and Structures ",2.0f));
            modules.add(new TechModule("Soil Mechanics ",2.0f));
            modules.add(new TechModule("Numerical Methods ",2.0f));
            modules.add(new TechModule("Fluid Mechanics ",2.0f));
            modules.add(new TechModule("Coastal Processes and Monitoring ",2.0f));
            modules.add(new TechModule("Environmental Geotechnology",2.0f));
        }
        //Geotechnology 5th  semester-------------------------------------------------------
        else if(department.equals("Engineering Technology") && semester.equals(5) && focusArea.equals("Geotechnology")){
            modules.add(new TechModule("Geotechnics ",3.0f));
            modules.add(new TechModule("Principles of Quality Management ",2.0f));
            modules.add(new TechModule("Structural Elements ",2.0f));
            modules.add(new TechModule("Geotechnical Site Investigations ",2.0f));
            modules.add(new TechModule("Techniques for Sustainable Construction ",2.0f));
            modules.add(new TechModule("Remote Sensing and GIS ",2.0f));
            modules.add(new TechModule("Geological Hazards and Monitoring ",2.0f));
            modules.add(new TechModule("Research Methodology ",1.0f));
            modules.add(new TechModule("Occupational Health and Safety ",2.0f));
        }
        //Geotechnology 6th  semester-------------------------------------------------------
        else if(department.equals("Engineering Technology") && semester.equals(6) && focusArea.equals("Geotechnology")){
            modules.add(new TechModule("Industrial Training/Internship",6.0f));
        }

        //Geotechnology 7th  semester-------------------------------------------------------
        else if(department.equals("Engineering Technology") && semester.equals(7) && focusArea.equals("Geotechnology")){
            modules.add(new TechModule("Rock Mechanics", 3.0f));
            modules.add(new TechModule("Project Management", 2.0f));
            modules.add(new TechModule("Surveying Applications and Geomatics", 2.0f));
            modules.add(new TechModule("Construction Estimation and Procurement", 2.0f));
            modules.add(new TechModule("Numerical Simulations for Geotechnology", 2.0f));
            modules.add(new TechModule("Innovation and Venture Creation",1.0f));
            modules.add(new TechModule("ETG 4271 Instrumentation and Troubleshooting", 0.0f));
        }
        //Geotechnology 8th  semester-------------------------------------------------------
        else if(department.equals("Engineering Technology") && semester.equals(8) && focusArea.equals("Geotechnology")){
            modules.add(new TechModule("Research and Design Project", 6.0f));
            modules.add(new TechModule( "Foundation Technology", 2.0f));
            modules.add(new TechModule("Ground Improvement Techniques", 2.0f));
            modules.add(new TechModule("Entrepreneurship and Small Business Management", 1.0f));
            modules.add(new TechModule("Contract Law and Dispute Resolution", 1.0f));
        }
        //Automobile Technology 3rd  semester-------------------------------------------------------
        else if(department.equals("Engineering Technology") && semester.equals(3) && focusArea.equals("Automobile Technology")){
            modules.add(new TechModule( "Thermodynamics",3.0f));
            modules.add(new TechModule("Mathematics (III)",2.0f));
            modules.add(new TechModule( "Economics and Financial Management",2.0f));
            modules.add(new TechModule( "Measurements and Instrumentation",2.0f));
            modules.add(new TechModule("Manufacturing Technology",2.0f));
            modules.add(new TechModule("Applied Electronics",2.0f));
            modules.add(new TechModule("Introduction to Automobile Technology",1.0f));
        }
        //Automobile Technology 4th  semester-------------------------------------------------------
        else if(department.equals("Engineering Technology") && semester.equals(4) && focusArea.equals("Automobile Technology")){
            modules.add(new TechModule("CADD Software Applications",2.0f));
            modules.add(new TechModule("Numerical Methods",2.0f));
            modules.add(new TechModule("Automobile Engines",2.0f));
            modules.add(new TechModule("Transmission Systems",2.0f));
            modules.add(new TechModule("Steering and Brake Systems",2.0f));
            modules.add(new TechModule("Fluid Mechanics",2.0f));
        }//Automobile Technology 5th semester-------------------------------------------------------
        else if(department.equals("Engineering Technology") && semester.equals(5) && focusArea.equals("Automobile Technology")){
            modules.add(new TechModule("Mechanics of Materials",3.0f));
            modules.add(new TechModule("Principles of Quality Management",2.0f));
            modules.add(new TechModule("Electrical & Electronic Systems in Vehicles",2.0f));
            modules.add(new TechModule("Automobile Air Conditioning and Auxiliary Systems",2.0f));
            modules.add(new TechModule("Sensors and Applications",2.0f));
            modules.add(new TechModule("Electrical Machines",2.0f));
            modules.add(new TechModule("Automobile Design Project",2.0f));
            modules.add(new TechModule("Research Methodology",1.0f));
            modules.add(new TechModule("Occupational Health and Safety",1.0f));
        }
        //Automobile Technology 6th  semester-------------------------------------------------------
        else if(department.equals("Engineering Technology") && semester.equals(6) && focusArea.equals("Automobile Technology")){
            modules.add(new TechModule("Industrial Training/Internship",6.0f));
        }
        //Automobile Technology 7th  semester-------------------------------------------------------
        else if(department.equals("Engineering Technology") && semester.equals(7) && focusArea.equals("Automobile Technology")){
            modules.add(new TechModule("Electronic Management Systems in Automobiles",3.0f));
            modules.add(new TechModule("Project Management",2.0f));
            modules.add(new TechModule("Alternative Fuels and Energy Systems",2.0f));
            modules.add(new TechModule("Vehicle Dynamics and Suspensions",2.0f));
            modules.add(new TechModule("Applied Hydraulics and Pneumatics",2.0f));
            modules.add(new TechModule("Automobile Workshop and Maintenance",2.0f));
            modules.add(new TechModule("Fuels and Lubrication",2.0f));
        }
        //Automobile Technology 8th  semester-------------------------------------------------------
        else if(department.equals("Engineering Technology") && semester.equals(8) && focusArea.equals("Automobile Technology")){
            modules.add(new TechModule("Research/Design Project",6.0f));
            modules.add(new TechModule("Power Electronics and Applications",3.0f));
            modules.add(new TechModule("Electric and Hybrid Vehicles",2.0f));
            modules.add(new TechModule( "Automobile Safety",2.0f));
            modules.add(new TechModule("Special Purpose Vehicles",2.0f));
            modules.add(new TechModule( "Entrepreneurship and Small Business Management",1.0f));
            modules.add(new TechModule("Career Development for a Technology Graduate",1.0f));
            modules.add(new TechModule("Intellectual Property Rights and Policies",1.0f));
        }
        //Mechatronics Technology 3rd semester-------------------------------------------------------
        else if(department.equals("Engineering Technology") && semester.equals(3) && focusArea.equals("Mechatronics Technology")){
            modules.add(new TechModule("Thermodynamics", 3.0f));
            modules.add(new TechModule("Mathematics (III)", 2.0f));
            modules.add(new TechModule("Economics and Financial Management", 2.0f));
            modules.add(new TechModule("Measurements and Instrumentation", 2.0f));
            modules.add(new TechModule("Manufacturing Technology", 2.0f));
            modules.add(new TechModule("Applied Electronics", 2.0f));
            modules.add(new TechModule("Introduction to Mechatronics Technology", 1.0f));
        }
        //Mechatronics Technology 4th semester-------------------------------------------------------
        else if(department.equals("Engineering Technology") && semester.equals(4) && focusArea.equals("Mechatronics Technology")){
            modules.add(new TechModule( "CADD Software Applications", 2.0f));
            modules.add(new TechModule( "Graphical Programming and Visual Instrumentation", 2.0f));
            modules.add(new TechModule( "Control Systems", 2.0f));
            modules.add(new TechModule( "Numerical Methods", 2.0f));
            modules.add(new TechModule("Fluid Mechanics", 2.0f));
            modules.add(new TechModule("Principles of Design", 2.0f));
            modules.add(new TechModule( "Embedded Systems and Applications", 2.0f));
        }
        //Mechatronics Technology 5th semester-------------------------------------------------------
        else if(department.equals("Engineering Technology") && semester.equals(5) && focusArea.equals("Mechatronics Technology")){
            modules.add(new TechModule("Mechanics of Materials", 3.0f));
            modules.add(new TechModule("Principles of Quality Management", 2.0f));
            modules.add(new TechModule("Building Automation", 2.0f));
            modules.add(new TechModule("Sensors and Applications", 2.0f));
            modules.add(new TechModule( "Electrical Machines", 2.0f));
            modules.add(new TechModule("Industrial Automation", 2.0f));
            modules.add(new TechModule("Mechatronics Design Project", 2.0f));
            modules.add(new TechModule( "Research Methodology", 1.0f));
            modules.add(new TechModule( "Occupational Health and Safety", 1.0f));
        }
        //Mechatronics Technology 6th semester-------------------------------------------------------
        else if(department.equals("Engineering Technology") && semester.equals(6) && focusArea.equals("Mechatronics Technology")){
            modules.add(new TechModule("Industrial Training/Internship", 6.0f));
        }
        //Mechatronics Technology 7th semester-------------------------------------------------------
        else if(department.equals("Engineering Technology") && semester.equals(7) && focusArea.equals("Mechatronics Technology")){
            modules.add(new TechModule("Robotic Technology", 3.0f));
            modules.add(new TechModule( "Project Management", 2.0f));
            modules.add(new TechModule( "Energy Management", 2.0f));
            modules.add(new TechModule( "Advanced Automation", 2.0f));
            modules.add(new TechModule("Applied Hydraulics and Pneumatics", 2.0f));
            modules.add(new TechModule( "Mechatronics System Modelling", 2.0f));
            modules.add(new TechModule("MEMS and NEMS", 2.0f));
        }
        //Mechatronics Technology 8th semester-------------------------------------------------------
        else if(department.equals("Engineering Technology") && semester.equals(8) && focusArea.equals("Mechatronics Technology")){
            modules.add(new TechModule( "Research/Design Project", 6.0f));
            modules.add(new TechModule( "Power Electronics and Applications", 3.0f));
            modules.add(new TechModule( "Machine Vision Systems", 2.0f));
            modules.add(new TechModule("Mechatronics for Automobile Applications", 2.0f));
            modules.add(new TechModule("Entrepreneurship and Small Business Management", 1.0f));
            modules.add(new TechModule( "Intellectual Property Rights and Policies", 1.0f));
        }
        //Polymer Processing Technology 3rd semester-------------------------------------------------------
        else if(department.equals("Engineering Technology") && semester.equals(3) && focusArea.equals("Polymer Processing Technology")){
            modules.add(new TechModule("Thermodynamics", 3.0f));
            modules.add(new TechModule( "Mathematics (III)", 2.0f));
            modules.add(new TechModule( "Economics & Financial Management", 2.0f));
            modules.add(new TechModule( "Introduction to Polymers", 2.0f));
            modules.add(new TechModule("Raw Rubber Manufacturing Technology", 2.0f));
            modules.add(new TechModule( "Dry Rubber Processing Technology", 2.0f));
            modules.add(new TechModule( "Raw Rubber Manufacturing Technology Practical", 2.0f));
            modules.add(new TechModule( "Dry Rubber Processing Technology Practical", 2.0f));
            modules.add(new TechModule( "Synthetic Rubbers", 1.0f));
        }
        //Polymer Processing Technology 4th semester-------------------------------------------------------
        else if(department.equals("Engineering Technology") && semester.equals(4) && focusArea.equals("Polymer Processing Technology")){
            modules.add(new TechModule("CADD Software Applications", 2.0f));
            modules.add(new TechModule( "Fluid Mechanics", 2.0f));
            modules.add(new TechModule( "Mechanical Properties of Polymers", 2.0f));
            modules.add(new TechModule( "Plastic Processing Technology", 2.0f));
            modules.add(new TechModule( "Plastic Processing Technology Practical", 2.0f));
            modules.add(new TechModule( "Polyurethane Technology", 2.0f));
            modules.add(new TechModule( "Polymer Composites and Applications", 2.0f));
            modules.add(new TechModule( "Heat and Mass Transfer", 1.0f));
            modules.add(new TechModule( "Polymer Rheology", 1.0f));
            modules.add(new TechModule( "Latex Processing Technology", 1.0f));
            modules.add(new TechModule( "Latex Processing Technology Practical", 1.0f));
        }
        //Polymer Processing Technology 5th semester-------------------------------------------------------
        else if(department.equals("Engineering Technology") && semester.equals(5) && focusArea.equals("Polymer Processing Technology")){
            modules.add(new TechModule( "Mechanics of Materials", 3.0f));
            modules.add(new TechModule( "Finite Elemental Analysis", 3.0f));
            modules.add(new TechModule( "Principles of Quality Management", 2.0f));
            modules.add(new TechModule( "Design and Manufacturing of Rubber Products", 2.0f));
            modules.add(new TechModule("Latex and Rubber Products Manufacturing Technology Practical", 2.0f));
            modules.add(new TechModule( "Design and Manufacturing of Latex Products", 1.0f));
            modules.add(new TechModule( "Research Methodology", 1.0f));
            modules.add(new TechModule( "Occupational Health and Safety", 1.0f));
        }
        //Polymer Processing Technology 6th semester-------------------------------------------------------
        else if(department.equals("Engineering Technology") && semester.equals(6) && focusArea.equals("Polymer Processing Technology")){
            modules.add(new TechModule("Industrial Training/Internship", 6.0f));
        }
        //Polymer Processing Technology 7th semester-------------------------------------------------------
        else if(department.equals("Engineering Technology") && semester.equals(7) && focusArea.equals("Polymer Processing Technology")){
            modules.add(new TechModule("Textile Technology", 2.0f));
            modules.add(new TechModule( "Industrial Chemical Engineering and Process Control", 2.0f));
            modules.add(new TechModule("Plastic Products Design", 2.0f));
            modules.add(new TechModule( "Analysis and Characterization of Polymers", 2.0f));
            modules.add(new TechModule( "Surface Coatings and Adhesive Technology", 2.0f));
            modules.add(new TechModule( "Mould and Die Design", 2.0f));
        }
        //Polymer Processing Technology 8th semester-------------------------------------------------------
        else if(department.equals("Engineering Technology") && semester.equals(8) && focusArea.equals("Polymer Processing Technology")){
            modules.add(new TechModule("Research/Final Design Project ",6.0f));
            modules.add(new TechModule("ETP 4342 Nanotechnology", 2.0f));
            modules.add(new TechModule("ETC 4271 Entrepreneurship and Small Business Management", 1.0f));
            modules.add(new TechModule("ETC 4291 Intellectual Property Rights and Policies", 1.0f));
            modules.add(new TechModule("ETP 4331 Recycling and Waste Management", 2.0f));
            modules.add(new TechModule("ETP 4351 Packaging Materials, Machinery & Processes", 2.0f));
            modules.add(new TechModule("ETP 4361 Specialty and Advanced Polymers and Their Applications", 2.0f));
        }
        return modules;

    }
}
