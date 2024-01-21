package com.jpura.gpacalculatorpro.model.ict;

import java.util.ArrayList;

public class BstModules {
    public static ArrayList<TechModule> getBstSemesterModules(String department, Integer semester, String focusArea){
        ArrayList<TechModule> modules = new ArrayList<>();

        if(department.equals("Bio System Technology") && semester.equals(1) && focusArea.equals("")){
            modules.add(new TechModule("BTC 1023 Physics for Technology ", 3.0f));
            modules.add(new TechModule("BTC 1013 Mathematics (I) ", 3.0f));
            modules.add(new TechModule("BTC 1032 Chemistry for Technology ", 3.0f));
            modules.add(new TechModule("BTC 1042 Engineering Drawing ", 2.0f));
            modules.add(new TechModule("BTC 1062 Computing for Technology  ", 2.0f));
            modules.add(new TechModule("BTC 1072 Communication Skills (I)/English", 2.0f));
            modules.add(new TechModule("BTC 1052 Principles of Statistics ", 2.0f));
            modules.add(new TechModule("BTC 1001 Technology Project", 1.0f));
            modules.add(new TechModule("BTC 1081 Ethical Conduct of Learners", 1.0f));

        }else if(department.equals("Bio System Technology") && semester.equals(2) && focusArea.equals("")){
            modules.add(new TechModule("BTC 1102 Mathematics (II)", 2.0f));
            modules.add(new TechModule("BTC 1112B iology for Technology", 2.0f));
            modules.add(new TechModule("BTC 1122 Introduction to Computer Programming", 2.0f));
            modules.add(new TechModule("BTC 1132 Statistical Methods", 2.0f));
            modules.add(new TechModule("BTC 1142 Principles of Design and Manufacturing", 2.0f));
            modules.add(new TechModule("BTC 1152 Principles of Microbiology", 2.0f));
            modules.add(new TechModule("BTC 1162 Communication Skills (II)/English", 2.0f));
            modules.add(new TechModule("BTC 1171 Personality Development", 1.0f));

        }else if(department.equals("Bio System Technology") && semester.equals(3) && focusArea.equals("Agriculture and Environmental Technology")){
            modules.add(new TechModule("BTA 2012 Principles of Biotechnology", 2.0f));
            modules.add(new TechModule("BTA 2022 Soilless Cultivation Technology", 2.0f));
            modules.add(new TechModule("BTA 2032 Sustainable Soil and Irrigation Systems", 2.0f));
            modules.add(new TechModule("BTA 2042 Agricultural Development and Policy", 2.0f));
            modules.add(new TechModule("BTA 2052 Composting Technology", 2.0f));
            modules.add(new TechModule("BTA 2063 Farm Machinery, Structures, and Automation", 3.0f));
            modules.add(new TechModule("BTA 2072 Plantation Crop Management", 2.0f));
            modules.add(new TechModule("BTA 2082 Technology Practicals (I)", 2.0f));
            modules.add(new TechModule("BTA 2092 Technology Workshops (I)", 2.0f));

        }else if(department.equals("Bio System Technology") && semester.equals(4) && focusArea.equals("Agriculture and Environmental Technology")){
            modules.add(new TechModule("BTA 2102 Agricultural Biotechnology", 2.0f));
            modules.add(new TechModule("BTA 2112 Surveying and Landscaping", 2.0f));
            modules.add(new TechModule("BTA 2122 Post-Harvest Technology", 2.0f));
            modules.add(new TechModule("BTA 2132 Phytotechnology and Applications", 2.0f));
            modules.add(new TechModule("BTA 2142 Urban Agricultural Technology", 2.0f));
            modules.add(new TechModule("BTA 2151 Environment Ecology", 1.0f));
            modules.add(new TechModule("BTA 2162 Agrochemicals and Environment Pollution", 2.0f));
            modules.add(new TechModule("BTA 2172 Technology Practicals (II)", 2.0f));
            modules.add(new TechModule("BTA 2182 Technology Workshops (II)", 2.0f));
            modules.add(new TechModule("BTC 2182 Economics and Financial Management", 2.0f));

        }else if(department.equals("Bio System Technology") && semester.equals(5) && focusArea.equals("Agriculture and Environmental Technology")){
            modules.add(new TechModule("BTA 3192 Meteorology and Applied Hydrology", 2.0f));
            modules.add(new TechModule("BTA 3202 Organic Agricultural Product Processing Technology", 2.0f));
            modules.add(new TechModule("BTA 3212 Animal Husbandry", 2.0f));
            modules.add(new TechModule("BTA 3222 Green Technologies for Sustainable Agriculture", 2.0f));
            modules.add(new TechModule("BTA 3231 Indigenous Knowledge Systems in Agriculture", 1.0f));
            modules.add(new TechModule("BTA 3242 Technology Practicals (III)", 2.0f));
            modules.add(new TechModule("BTA 3252 Technology Workshops (III)", 2.0f));
            modules.add(new TechModule("BTC 3192 Principles of Quality Management", 2.0f));
            modules.add(new TechModule("BTC 3201 Professional Ethics*", 1.0f));

        }else if (department.equals("Bio System Technology") && semester.equals(6) && focusArea.equals("Agriculture and Environmental Technology")) {
            modules.add(new TechModule("BTA 3262 Precision Agriculture Technology", 2.0f));
            modules.add(new TechModule("BTA 3272 Water Resource and Water Quality Management", 2.0f));
            modules.add(new TechModule("BTA 3282 Waste Management Technology", 2.0f));
            modules.add(new TechModule("BTA 3292 Animal Feed Technology", 2.0f));
            modules.add(new TechModule("BTA 3302 Plant Propagation Technologies", 2.0f));
            modules.add(new TechModule("BTA 3312 Technology Practicals (IV)", 2.0f));
            modules.add(new TechModule("BTA 3322 Technology Workshops (IV)", 2.0f));
            modules.add(new TechModule("BTC 3211 Research Methods and Scientific Writing", 1.0f));
            modules.add(new TechModule("BTC 3221 Occupational Health and Safety", 1.0f));
            modules.add(new TechModule("BTC 3231 Creative Designing*", 1.0f));

        }else if (department.equals("Bio System Technology") && semester.equals(7) && focusArea.equals("Agriculture and Environmental Technology")) {
            modules.add(new TechModule("BTA 4336 Industrial Training/Internship", 6.0f));
            modules.add(new TechModule("BTA 4996 Research and Design Project", 6.0f));

        }else if (department.equals("Bio System Technology") && semester.equals(8) && focusArea.equals("Agriculture and Environmental Technology")) {
            modules.add(new TechModule("BTA 4342 Hybrid Seed Technology", 2.0f));
            modules.add(new TechModule("BTA 4352 Animal Product Technology", 2.0f));
            modules.add(new TechModule("BTA 4371 Innovation Advancements", 1.0f));
            modules.add(new TechModule("BTA 4996 Research and Design Project Contd.", 6.0f));
            modules.add(new TechModule("BTC 4241 Career Development for a Technology Graduate", 1.0f));
            modules.add(new TechModule("BTC 4251 Entrepreneurship and Small Business Management", 1.0f));

        }else if (department.equals("Bio System Technology") && semester.equals(3) && focusArea.equals("Food Processing Technology")) {
            modules.add(new TechModule("BTF 2012 Principles of Food Process Technology", 2.0f));
            modules.add(new TechModule("BTF 2022 Principles of Food Biochemistry", 2.0f));
            modules.add(new TechModule("BTF 2032 Food Physics", 2.0f));
            modules.add(new TechModule("BTF 2042 Industrial Microbiology", 2.0f));
            modules.add(new TechModule("BTF 2052 Post-Harvest Management Technology", 2.0f));
            modules.add(new TechModule("BTF 2061 Indigenous Knowledge in Food Process Technology", 1.0f));
            modules.add(new TechModule("BTF 2072 Food Safety and Legislation Management", 2.0f));
            modules.add(new TechModule("BTF 2081 Behavioral Aspects of Marketing (I)", 1.0f));
            modules.add(new TechModule("BTF 2092 Technology Practicals (I)", 2.0f));
            modules.add(new TechModule("BTF 2102 Technology Workshops (I)", 2.0f));

        } else if (department.equals("Bio System Technology") && semester.equals(4) && focusArea.equals("Food Processing Technology")) {
            modules.add(new TechModule("BTF 2112 Food Manufacturing Technology", 2.0f));
            modules.add(new TechModule("BTF 2122 Agroproducts Technology", 2.0f));
            modules.add(new TechModule("BTF 2132 Beverage Processing Technology", 2.0f));
            modules.add(new TechModule("BTF 2142 Spices and Condiments Technology", 2.0f));
            modules.add(new TechModule("BTF 2162 Principles of Product Designing", 2.0f));
            modules.add(new TechModule("BTF 2171 Behavioral Aspects of Marketing (II)", 1.0f));
            modules.add(new TechModule("BTF 2182 Technology Practicals (II)", 2.0f));
            modules.add(new TechModule("BTF 2192 Technology Workshops (II)", 2.0f));
            modules.add(new TechModule("BTC 2182 Economics and Financial Management", 2.0f));

        } else if (department.equals("Bio System Technology") && semester.equals(5) && focusArea.equals("Food Processing Technology")) {
            modules.add(new TechModule("BTF 3202 Bakery and Confectioneries Processing Technology", 2.0f));
            modules.add(new TechModule("BTF 3212 Livestock and Aqua Product Technology", 2.0f));
            modules.add(new TechModule("BTF 3222 Extrusion Technology", 2.0f));
            modules.add(new TechModule("BTF 3232 Food Enzyme Technology", 2.0f));
            modules.add(new TechModule("BTF 3242 Advance Topics in Food Technology", 2.0f));
            modules.add(new TechModule("BTF 3252 Processing Plant Designing", 2.0f));
            modules.add(new TechModule("BTF 3262 Technology Practicals (III)", 2.0f));
            modules.add(new TechModule("BTF 3272 Technology Workshops (III)", 2.0f));
            modules.add(new TechModule("BTC 3192 Principles of Quality Management", 2.0f));
            modules.add(new TechModule("BTC 3201 Professional Ethics*", 1.0f));

        } else if (department.equals("Bio System Technology") && semester.equals(6) && focusArea.equals("Food Processing Technology")) {
            modules.add(new TechModule("BTF 3282 Milk and Milk Product Technology", 2.0f));
            modules.add(new TechModule("BTF 3292 Oil and Legume Seed Processing Technology", 2.0f));
            modules.add(new TechModule("BTF 3302 Food Quality and Sensory Analysis", 2.0f));
            modules.add(new TechModule("BTF 3311 Food Packaging Technology", 1.0f));
            modules.add(new TechModule("BTF 3321 Supply Chain Management", 1.0f));
            modules.add(new TechModule("BTF 3331 Seminars on Special Topics", 1.0f));
            modules.add(new TechModule("BTF 3342 Technology Practicals (IV)", 2.0f));
            modules.add(new TechModule("BTF 3352 Technology Workshops (IV)", 2.0f));
            modules.add(new TechModule("BTF 3361 Automation Technology for Food Industry", 1.0f));
            modules.add(new TechModule("BTC 3211 Research Methods and Scientific Writing", 1.0f));
            modules.add(new TechModule("BTC 3221 Occupational Health and Safety", 1.0f));
            modules.add(new TechModule("BTC 3231 Creative Designing*", 1.0f));

        } else if (department.equals("Bio System Technology") && semester.equals(7) && focusArea.equals("Food Processing Technology")) {
            modules.add(new TechModule("BTF 4366 Industrial Training/Internship", 6.0f));
            modules.add(new TechModule("BTF 4996 Research and Design Project", 6.0f));

        } else if (department.equals("Bio System Technology") && semester.equals(8) && focusArea.equals("Food Processing Technology")) {
            modules.add(new TechModule("BTF 4372 Novel Applications in Food Technology", 2.0f));
            modules.add(new TechModule("BTF 4382 Cleaner Production Technology", 2.0f));
            modules.add(new TechModule("BTF 4391 Feasibility Study for Food Processing", 1.0f));
            modules.add(new TechModule("BTF 4996 Research and Design Project Contd.", 6.0f));
            modules.add(new TechModule("BTC 4241 Career Development for a Technology Graduate", 1.0f));
            modules.add(new TechModule("BTC 4251 Entrepreneurship and Small Business Management", 1.0f));

        } else if (department.equals("Bio System Technology") && semester.equals(3) && focusArea.equals("Industrial Biosystems Technology")) {
            modules.add(new TechModule("BTI 2012 Molecular Basis of Biological Systems", 2.0f));
            modules.add(new TechModule("BTI 2022 Bioresources and Bioeconomy", 2.0f));
            modules.add(new TechModule("BTI 2032 Principles of Biotechnology", 2.0f));
            modules.add(new TechModule("BTI 2042 Fermentation Technology", 2.0f));
            modules.add(new TechModule("BTI 2052 Enzyme Technology", 2.0f));
            modules.add(new TechModule("BTI 2062 Plant Micropropagation and Cell Culture Technology", 2.0f));
            modules.add(new TechModule("BTI 2072 Technology Practicals (I)", 2.0f));
            modules.add(new TechModule("BTI 2082 Technology Workshops (I)", 2.0f));
            modules.add(new TechModule("BTI 2091 Behavioral Aspects of Marketing (I)", 1.0f));

        } else if (department.equals("Bio System Technology") && semester.equals(4) && focusArea.equals("Industrial Biosystems Technology")) {
            modules.add(new TechModule("BTI 2103 Industrial Bioprocess Technology", 3.0f));
            modules.add(new TechModule("BTI 2112 Biotechnology in Agro-industries", 2.0f));
            modules.add(new TechModule("BTI 2122 Methods in Analytical Chemistry", 2.0f));
            modules.add(new TechModule("BTI 2132 Marine Bioresources and Applications", 2.0f));
            modules.add(new TechModule("BTI 2142 Industrial Applications of Environment Extremophiles", 2.0f));
            modules.add(new TechModule("BTI 2152 Technology Practicals (II)", 2.0f));
            modules.add(new TechModule("BTI 2162 Technology Workshops (II)", 2.0f));
            modules.add(new TechModule("BTI 2171 Behavioral Aspects of Marketing (II)", 1.0f));
            modules.add(new TechModule("BTC 2182 Economics and Financial Management", 2.0f));

        } else if (department.equals("Bio System Technology") && semester.equals(5) && focusArea.equals("Industrial Biosystems Technology")) {
            modules.add(new TechModule("BTI 3182 Advanced Industrial Bioprocess Technology", 2.0f));
            modules.add(new TechModule("BTI 3192 Herbal Processing Technology", 2.0f));
            modules.add(new TechModule("BTI 3202 Aquaculture Technology", 2.0f));
            modules.add(new TechModule("BTI 3212 Biomimicry, Biomaterials, and Biosensors", 2.0f));
            modules.add(new TechModule("BTI 3222 Biopharmaceutical Processing Technology", 2.0f));
            modules.add(new TechModule("BTI 3232 Technology Practicals (III)", 2.0f));
            modules.add(new TechModule("BTI 3242 Technology Workshops (III)", 2.0f));
            modules.add(new TechModule("BTI 3251 Animal Cell Culture Technology", 1.0f));
            modules.add(new TechModule("BTC 3192 Principles of Quality Management", 2.0f));
            modules.add(new TechModule("BTC 3201 Professional Ethics*", 1.0f));

        } else if (department.equals("Bio System Technology") && semester.equals(6) && focusArea.equals("Industrial Biosystems Technology")) {
            modules.add(new TechModule("BTI 3262 Environmental Biotechnology", 2.0f));
            modules.add(new TechModule("BTI 3272 Applied Bioinformatics", 2.0f));
            modules.add(new TechModule("BTI 3281 Bioethics for Technologists", 1.0f));
            modules.add(new TechModule("BTI 3292 Waste Management Technology", 2.0f));
            modules.add(new TechModule("BTI 3301 Seminar on Special Topics", 1.0f));
            modules.add(new TechModule("BTI 3312 Technology Practicals (IV)", 2.0f));
            modules.add(new TechModule("BTI 3322 Technology Workshops (IV)", 2.0f));
            modules.add(new TechModule("BTI 3332 Cleaner Production Technology", 2.0f));
            modules.add(new TechModule("BTI 3341 Store and Warehouse Management", 1.0f));
            modules.add(new TechModule("BTC 3211 Research Methodology and Scientific Writing", 1.0f));
            modules.add(new TechModule("BTC 3221 Occupational Health and Safety", 1.0f));
            modules.add(new TechModule("BTC 3231 Creative Designing*", 1.0f));

        } else if (department.equals("Bio System Technology") && semester.equals(7) && focusArea.equals("Industrial Biosystems Technology")) {
            modules.add(new TechModule("BTI 4356 Industrial Training/Internship", 6.0f));
            modules.add(new TechModule("BTI 4996 Research and Design Project", 6.0f));

        } else if (department.equals("Bio System Technology") && semester.equals(8) && focusArea.equals("Industrial Biosystems Technology")) {
            modules.add(new TechModule("BTI 4362 Cosmetic Technology", 2.0f));
            modules.add(new TechModule("BTI 4371 Immunotechnology", 1.0f));
            modules.add(new TechModule("BTI 4382 Nanobiotechnology", 2.0f));
            modules.add(new TechModule("BTI 4996 Research and Design Project Contd.", 6.0f));
            modules.add(new TechModule("BTC 4241 Career Development for a Technology Graduate", 1.0f));
            modules.add(new TechModule("BTC 4251 Entrepreneurship and Small Business Management", 1.0f));
        }


        return modules;
    }

}
