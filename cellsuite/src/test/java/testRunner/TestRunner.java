package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/",
    glue = {"stepDefinition"},
    // tags = "@usermanagement",
    // tags = "@reagentlibrary", // and @Z or @A
    // tags = "@CC-1080_Create_new_Reagent",
    // tags = "@CC-1103_Create_new_reagent_with_new_culture_reagent",
    // tags = "@CC-1128_Edit_one_reagent_item",
    // tags = "@CC-1130_Edit_multiple_reagent_item",
    // tags = "@CC-1105_Delete_one_reagent_item",
    // tags = "@CC-1106_Delete_multiple_reagent_item",

    // tags = "@reagentculture", // and @Z or @A
    // tags = "@CC-1102_Create_new_Culture_Reagent",
    // tags = "@CC-1110_Delete_One_Culture_Reagent",
    // tags = "@CC-1132_Edit_One_Culture_Reagent_Item",
    // tags = "@CC-1131_Edit_Multiple_Culture_Reagent_Item",

    // tags = "@cellline", // and @Z or @A
    // tags = "@CC-1043_Create_new_Cell_Line_by_filling_all_fields",
    // tags = "@CC-1044_Create_new_Cell_Line_by_filling_required_fields_only",
    // tags = "@CC-1045_Create_new_Cell_Line_by_filling_not_required_fields_only",
    // tags = "@CC-1056_Create_Cell_Line_which_already_exist",
    // tags = "@CC-1115_Create_Cell_Line_with_Passage_After_Confluency",
    // tags = "@CC-1116_Create_new_Cell_Line_with_Passage_After_Time_Interval_and_Imaging_Interval",
    // tags = "@CC-1117_Create_new_Cell_Line_with_Passage_After_Time_Interval_and_without_Imaging_Interval",

    // tags = "@CC-1049_Delete_one_Cell_Line",
    // tags = "@CC-1050_Delete_multiple_Cell_Line",
    // tags = "@CC-1051_Cancel_delete_Cell_Line",
    // tags = "@CC-1052_Delete_Cell_Line_which_already_used_in_inventory",

    // tags = "@CC-1046_Edit_one_Cell_Line",
    // tags = "@CC-1048_Edit_Cell_Line_name_with_an_exist_name",
    // tags = "@CC-1119_Change_from_Time_Interval_with_Imaging_Interval_to_Confluency",
    // tags = "@CC-1121_Change_Passage_After_Confluency_into_Time_Interval_with_Imaging_Interval",
    // tags = "@CC-1125_Change_Passage_After_Confluency_into_Time_Interval_without_Imaging_Interval",

    // tags = "@CC-1122_User_registering_multiple_Pre-barcoded_labwares",
    // tags = "@CC-1123_Registering_Pre-barcoded_labware_without_selecting_Storage_Location",
    // tags = "@CC-1124_User_registering_trough_with_content",
    // tags = "@CC-1134_User_registering_empty_trough",
    // tags = "@CC-1141_User_registering_tip_caddy",
    // tags = "@CC-1142_User_registering_empty_counting_plate",
    // tags = "@CC-1143_User_register_multiple_empty_96_Wells_plate",
    tags = "@CC-1144_User_register_single_empty_one_Well_plate",
    // tags = "@CC-1152_User_register_microplate_with_content",
    // tags = "@CC-1153_User_saving_without_completing_the_required_fields",
    // tags = "@CC-1154_User_cancel_register_labware",

    // tags = "@CC-1155_User_print_barcode_for_single_labware",
    // tags = "@CC-1156_User_print_barcodes_for_multiple_labware",
    // tags = "@CC-1157_User_print_barcode_while_registering_labware",
    // tags = "@CC-1159_User_attempt_to_print_barcode_for_the_prebarcoded_labware",

    // tags = "@CC-1160_User_attempt_to_print_barcode_while_registering_labware_as_prebarcoded",
    // tags = "@CC-1161_User_attemtp_to_print_prebarcoded_and_non-prebarcoded_labware_at_once",

    // tags = "@CC-1162_User_delete_single_unused_labware",
    // tags = "@CC-1163_User_delete_multiple_unused_labware",
    // tags = "@CC-1166_User_cancel_delete_labware",


    monochrome = false,
    plugin = {"pretty", "html:target/htmlReport/reports.html",
                        "json:target/jsonReport/reports.json",
                        "junit:target/junitReport/reports.xml"}
)
class TestRunner {

}
