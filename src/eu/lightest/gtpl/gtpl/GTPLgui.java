/* GTPLgui.java
 *
 * Copyright (C) 2020
 * Copyright (C) DTU(Technical University of Denmark) 2020
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the Apache license.  See the LICENSE.txt file for details.
 */
package eu.lightest.gtpl.gtpl;

import eu.lightest.gtpl.GTPL;
import eu.lightest.gtpl.formats.FormFomat;
import eu.lightest.gtpl.formats.Format;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import eu.lightest.gtpl.parser.nlFormatMaker;
import eu.lightest.gtpl.parser.nlLexer;
import eu.lightest.gtpl.parser.nlParser;
import eu.lightest.gtpl.tools.TranslationFormat2Tpl;
import eu.lightest.gtpl.datatype.*;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *
 * @author bnia
 */
public final class GTPLgui {
  private final ObservableList trustpolicys_ = FXCollections.observableArrayList();
  private ArrayList<TrustPolicy> trustPolicyList_ = new ArrayList<>();
  private final ObservableList formats_ = FXCollections.observableArrayList();
  private final ObservableList certificates_ = FXCollections.observableArrayList();
  private ListView formatListView_;
  private ListView certificateListView_;
  private final ListView gtplListView_;
  private final TextArea viewPolicy_ = new TextArea();;
  private Form globalForm_;
  private TabPane centerPane_;
  private TabPane leftPane_;
  private Tab globalCenterTab_;
  private Tab globalLeftTab_;
  private TrustPolicy selectedPolicy_;
  private final String gtplListViewName_ = "Untitled";
  private boolean isEditable_ = false;
  private final HashMap<String, FormFormat> formatMap_ = new HashMap<>();
  private final HashMap<String, Certificate> certificateMap_ = new HashMap<>();
  private static int ruleNameCounter_ = 1;
  private String ruleName_ = "Policy rule " + ruleNameCounter_;
  Format format = new FormFomat();

  public GTPLgui(){
    //initial .gtpl list view. It is a empty list with tab name "Untitled"
    gtplListView_ = new ListView(trustpolicys_);
    gtplListView_.setCellFactory(param -> new MyGTPLRules());
    globalLeftTab_ = generateTab(gtplListViewName_, gtplListView_);

    ArrayList<Form> sortedFormats = format.allFormats();
    Collections.sort(sortedFormats,Form.FormatNameComparator);
    //load all form formats from library into variable of formats and formatMap
    for(Form form : sortedFormats){
      FormFormat formFormat = new FormFormat(form);
      formats_.add(formFormat);
      formatMap_.put(formFormat.format.identifier.dispalyName,formFormat);
    }
    ArrayList<Form> sortedcertifacates = format.allCertificate();
    Collections.sort(sortedcertifacates,Form.FormatNameComparator);
    // load all certificates from library into variable of certificates and certificateMap
    for(Form certifacate : sortedcertifacates){
      Certificate certificate = new Certificate(certifacate);
      certificates_.add(certificate);
      certificateMap_.put(certifacate.identifier.dispalyName,certificate);
    }
  }

  /**
   This method creates the Layout of the GTPL application
   @param primaryStage
   */
  public void homePane(Stage primaryStage){
    primaryStage.setTitle("LIGHTest GTPL");

    BorderPane borderPane = new BorderPane();
    borderPane.setPadding(new Insets(0, 10, 10, 10));

    MenuBar mainMenu = new MenuBar();
    //Declare sub-menus and add to main menu.
    Menu newFile = new Menu("File");
    MenuItem newGTPLfile = new MenuItem("New GTPL File");
    newGTPLfile.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
    MenuItem openGTPLfile = new MenuItem("Open GTPL File");
    openGTPLfile.setAccelerator(KeyCombination.keyCombination("Ctrl+O"));
    MenuItem openNLfile = new MenuItem("Open NL File");
    openNLfile.setAccelerator(KeyCombination.keyCombination("Ctrl+L"));
    MenuItem openTPLfile = new MenuItem("View TPL File");
    openTPLfile.setAccelerator(KeyCombination.keyCombination("Ctrl+T"));
    MenuItem exitApp = new MenuItem("Exit");
    exitApp.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));
    newFile.getItems().addAll(newGTPLfile, openGTPLfile, openNLfile, openTPLfile,exitApp);

    Menu view = new Menu("View");
    MenuItem viewAllFormats = new MenuItem("View all formats");
    viewAllFormats.setAccelerator(KeyCombination.keyCombination("Ctrl+F"));
    MenuItem viewTextArea = new MenuItem("View TPL window");
    viewTextArea.setAccelerator(KeyCombination.keyCombination("Ctrl+W"));
    view.getItems().addAll(viewAllFormats,viewTextArea);

    Menu help = new Menu("Help");
    MenuItem visitWebsite = new MenuItem("Visit Website");
    help.getItems().add(visitWebsite);
    mainMenu.getMenus().addAll(newFile, view, help);

    // Declare buttons in toolbar
    ToolBar toolBar = new ToolBar();
    Button saveTPLfileButton = new Button("Save");
    toolBar.getItems().add(saveTPLfileButton);

    Button editButton = new Button("Edit");
    toolBar.getItems().add(editButton);

    Button deleteButton = new Button("Delete");
    toolBar.getItems().add(deleteButton);

    Button newRuleButton = new Button("New Rule");
    toolBar.getItems().add(newRuleButton);

    Region spring = new Region();
    HBox.setHgrow(spring, Priority.ALWAYS);
    toolBar.getItems().add(spring);
    TextField searchField = new TextField();
    searchField.setPromptText("Search");
    toolBar.getItems().add(searchField);

    VBox topVbox = new VBox(mainMenu,toolBar);
    borderPane.setTop(topVbox);

    //Setup Center and Right
    TabPaneWrapper wrapper = new TabPaneWrapper(Orientation.HORIZONTAL, .8);
    centerPane_ = new TabPane();
    centerPane_.setStyle("-fx-background-color: #F5F9FA;");
    TabPane rightPane = new TabPane();
    formatListView_ = new ListView(formats_);
    certificateListView_ = new ListView(certificates_);
    rightPane.getTabs().addAll(generateTab("Formats", formatListView_),generateTab("Certificates", certificateListView_));
    SplitPane.setResizableWithParent(rightPane, false);
    wrapper.addNodes(centerPane_, rightPane);

    //Add bottom
    TabPane bottomPane = new TabPane();
    bottomPane.getTabs().add(generateTab("TPL:",viewPolicy_));
    TabPaneWrapper wrapperBottom = new TabPaneWrapper(Orientation.VERTICAL, .8);
    wrapperBottom.addNodes(wrapper.getNode(), bottomPane);

    //Add left
    leftPane_ = new TabPane();
    leftPane_.getTabs().add(globalLeftTab_);
    TabPaneWrapper wrapperleft = new TabPaneWrapper(Orientation.HORIZONTAL, .2);
    wrapperleft.addNodes(leftPane_, wrapperBottom.getNode());
    borderPane.setCenter(wrapperleft.getNode());

    //Handing events
    // When user clicks on the Open new GTPL file item on MenuBar.
    newGTPLfile.setOnAction((ActionEvent event) -> {
      trustpolicys_.clear();
      if(!leftPane_.getTabs().isEmpty()){
        leftPane_.getTabs().remove(globalLeftTab_);
      }
      globalLeftTab_ = generateTab(gtplListViewName_,gtplListView_);
      leftPane_.getTabs().add(globalLeftTab_);
    });

    // When user clicks on the Open Edit GTPL file item on MenuBar.
    openGTPLfile.setOnAction((ActionEvent event) -> {
      FileChooser fileChooser = new FileChooser();
      fileChooser.getExtensionFilters().addAll(
              new FileChooser.ExtensionFilter("GTPL Files", "*.gtpl")
      );
      File gtplFile = fileChooser.showOpenDialog(primaryStage);
      if (gtplFile != null) {
        trustPolicyList_ = readGTPLpolicyFromFile(gtplFile);
        trustpolicys_.clear();
        trustpolicys_.addAll(trustPolicyList_);
        if(!leftPane_.getTabs().isEmpty()){
          leftPane_.getTabs().remove(globalLeftTab_);
        }
        globalLeftTab_ = generateTab(gtplFile.getName(),gtplListView_);
        leftPane_.getTabs().add(globalLeftTab_);
      }
    });

    // When user clicks on the Open NL file item on MenuBar.
    openNLfile.setOnAction((ActionEvent event) -> {
      FileChooser fileChooser = new FileChooser();
      fileChooser.getExtensionFilters().addAll(
              new FileChooser.ExtensionFilter("NL Files", "*.txt")
      );
      File nlFile = fileChooser.showOpenDialog(primaryStage);
      if (nlFile != null) {
        Path nlFilePath = nlFile.toPath();
        // open the input file
        try {
          CharStream input = CharStreams.fromPath(nlFilePath);
          // create a lexer/scanner
          nlLexer lex = new nlLexer(input);
          // get the stream of tokens from the scanner
          CommonTokenStream tokens = new CommonTokenStream(lex);
          // create a parser
          nlParser parser = new nlParser(tokens);
          // and parse anything from the grammar for "nl"
          ParseTree parseTree = parser.nl();
          // Construct an interpreter and run it on the parse tree
          nlFormatMaker formatMaker = new nlFormatMaker();
          AST formats = formatMaker.visit(parseTree);
          //System.out.println("The constructed format: \n"+format);

          TranslationFormat2Tpl TL = new TranslationFormat2Tpl();

          ArrayList<TrustPolicy> nlTrustPolicies = new ArrayList<>();
          int ruleCounter = 0;
          for(Form f : ((Forms)formats).forms){
            ruleCounter++;
            String tpl = TL.translationToplevel(f);
            TrustPolicy nlTrustPolicy = new TrustPolicy();
            nlTrustPolicy.form = f;
            nlTrustPolicy.ruleName = "NL policy rule " + ruleCounter;
            nlTrustPolicy.tpl = tpl;
            nlTrustPolicies.add(nlTrustPolicy);
          }
          trustPolicyList_ = nlTrustPolicies;
          trustpolicys_.clear();
          trustpolicys_.addAll(trustPolicyList_);
          if(!leftPane_.getTabs().isEmpty()){
            leftPane_.getTabs().remove(globalLeftTab_);
          }
          globalLeftTab_ = generateTab("NLpolicys",gtplListView_);
          leftPane_.getTabs().add(globalLeftTab_);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    });

    // When user clicks on the View TPL file item on MenuBar.
    openTPLfile.setOnAction((ActionEvent event) -> {
      FileChooser fileChooser = new FileChooser();
      fileChooser.getExtensionFilters().add(
              new FileChooser.ExtensionFilter("TPL Files", "*.tpl")
      );
      File openFile = fileChooser.showOpenDialog(primaryStage);
      if (openFile != null) {
        Scanner sc;
        try {
          sc = new Scanner(openFile);
          //using \\Z as delimiter
          sc.useDelimiter("\\Z");
          viewPolicy_.setText(sc.next());
        } catch (FileNotFoundException ex) {
          Logger.getLogger(GTPL.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    });

    exitApp.setOnAction(e -> Platform.exit());

    // When user clicks on the Open View all formats file item on MenuBar.
    viewAllFormats.setOnAction((ActionEvent event) -> {
      if(!rightPane.getTabs().isEmpty()){
        rightPane.getTabs().clear();
      }
      rightPane.getTabs().add(generateTab("Formats", formatListView_));
      rightPane.getTabs().add(generateTab("Certificates", certificateListView_));
    });

    // When user clicks on the Open View all formats file item on MenuBar.
    viewTextArea.setOnAction((ActionEvent event) -> {
      if(!bottomPane.getTabs().isEmpty()){
        bottomPane.getTabs().clear();
      }
      bottomPane.getTabs().add(generateTab("TPL:",viewPolicy_));
    });

    // When user clicks on the Save button.
    saveTPLfileButton.setOnAction((ActionEvent event) -> {
      String tpl="";
      for(Object policy : trustpolicys_){
        tpl += ((TrustPolicy)policy).tpl;
      }
      FileChooser fileChooser = new FileChooser();
      fileChooser.getExtensionFilters().addAll(
              new FileChooser.ExtensionFilter("TPL Files", "*.tpl")
      );
      File file = fileChooser.showSaveDialog(primaryStage);
      if (file != null) {
        globalLeftTab_.getTabPane().getTabs().remove(globalLeftTab_);
        globalLeftTab_ = generateTab(file.getName(),gtplListView_);
        leftPane_.getTabs().add(globalLeftTab_);
        writeTrustPolicyToFile(file,tpl);
        writeGTPLpolicyToFile(file.getAbsolutePath().replaceFirst("[.][^.]+$", "") + ".gtpl", trustPolicyList_);
      }
    });

    // When user clicks on the Edit button.
    editButton.setOnAction((ActionEvent event) -> {
      if(!centerPane_.getTabs().isEmpty()){
        centerPane_.getTabs().clear();
      }
      isEditable_ = true;
      if(gtplListView_.getSelectionModel().getSelectedItem() != null){
        selectedPolicy_ = (TrustPolicy)gtplListView_.getSelectionModel().getSelectedItem();
        globalCenterTab_ = generateTab(selectedPolicy_.form.identifier.dispalyName,selectedPolicy_.ruleName,selectedPolicy_.form);
        centerPane_.getTabs().add(globalCenterTab_);
      }
    });
    //double click on policy rule of GTPL
    gtplListView_.setOnMouseClicked((MouseEvent mouseEvent) -> {
      if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
        if(mouseEvent.getClickCount() == 2){
          if(!centerPane_.getTabs().isEmpty()){
            centerPane_.getTabs().clear();
          }
          isEditable_ = true;
          if(gtplListView_.getSelectionModel().getSelectedItem() != null){
            selectedPolicy_ = (TrustPolicy)gtplListView_.getSelectionModel().getSelectedItem();
            globalCenterTab_ = generateTab(selectedPolicy_.form.identifier.dispalyName,selectedPolicy_.ruleName,selectedPolicy_.form);
            centerPane_.getTabs().add(globalCenterTab_);
            String tpl = selectedPolicy_.tpl;
            viewPolicy_.setText(tpl);
          }
        }
      }
    });

    // When user clicks on the delete button
    deleteButton.setOnAction((ActionEvent event) -> {
      TrustPolicy selectedItem = (TrustPolicy)gtplListView_.getSelectionModel().getSelectedItem();
      trustpolicys_.remove(selectedItem);
      trustPolicyList_.remove(selectedItem);
    });

    // When user clicks on the new rule button.
    newRuleButton.setOnAction((ActionEvent event) -> {
      if(!centerPane_.getTabs().isEmpty()){
        centerPane_.getTabs().clear();
      }
      isEditable_ = false;
      if(formatListView_.getSelectionModel().getSelectedItem() != null){
        FormFormat selectedItem = (FormFormat)formatListView_.getSelectionModel().getSelectedItem();
        globalForm_ = (Form)deepClone(selectedItem.format);
        //ScrollPane scrollpane = createFormPane("Rule " + ruleNameCounter, form, form);
        globalCenterTab_ = generateTab(globalForm_.identifier.dispalyName,ruleName_,globalForm_);
        centerPane_.getTabs().add(globalCenterTab_);
      }else{
        showAlert(Alert.AlertType.WARNING, borderPane.getScene().getWindow(), "Warning", "Please select a Format!!!");
      }
    });

    rightPane.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Tab> observable, Tab oldTab, Tab newTab) -> {
      if(newTab.equals (rightPane.getSelectionModel().getSelectedItem())) {
        searchField.setText("");
      }
    });

    FilteredList<FormFormat> filteredFormats = new FilteredList<>(formats_, e -> true);
    FilteredList<Certificate> filteredCertificates = new FilteredList<>(certificates_, e -> true);
    searchField.setOnKeyReleased(e -> {
      if(rightPane.getSelectionModel().getSelectedItem().getText().equals("Formats")){
        searchField.textProperty().addListener((observableValue, oldValue, newValue) -> {
          filteredFormats.setPredicate((Predicate<? super FormFormat>) formFormt -> {
            if(newValue == null || newValue.isEmpty()){
              return true;
            }
            String lowerCaseFilter = newValue.toLowerCase();
            if(formFormt.toString().toLowerCase().contains(lowerCaseFilter)){
              return true;
            }
            return false;
          });
        });
        SortedList<FormFormat> sortFormats = new SortedList<>(filteredFormats);
        formatListView_.setItems(sortFormats);
      }else if(rightPane.getSelectionModel().getSelectedItem().getText().equals("Certificates")){
        searchField.textProperty().addListener((observableValue, oldValue, newValue) -> {
          filteredCertificates.setPredicate((Predicate<? super Certificate>) certificate -> {
            if(newValue == null || newValue.isEmpty()){
              return true;
            }
            String lowerCaseFilter = newValue.toLowerCase();
            if(certificate.toString().toLowerCase().contains(lowerCaseFilter)){
              return true;
            }
            return false;
          });
        });
        SortedList<Certificate> sortCertificates = new SortedList<>(filteredCertificates);
        certificateListView_.setItems(sortCertificates);
      }
    });

    //initialize Listeners for drag and drop events
    initializeListeners();
    Scene myScene = new Scene(borderPane,1400,750);//1600 1000
    primaryStage.setScene(myScene);
    primaryStage.sizeToScene();
    primaryStage.show();
  }

  /**
   This method initialize Listeners for drag and drop events
   */
  public void initializeListeners(){
    formatListView_.setOnDragDetected((MouseEvent event) -> {
      //System.out.println("setOnDragDetected");
      Dragboard dragBoard = formatListView_.startDragAndDrop(TransferMode.MOVE);
      ClipboardContent content = new ClipboardContent();
      FormFormat selectedItem = (FormFormat)formatListView_.getSelectionModel().getSelectedItem();
      content.putString(selectedItem.toString());
      dragBoard.setContent(content);
      event.consume();
    });

    formatListView_.setOnDragDone((DragEvent dragEvent) -> {
      //System.out.println("setOnDragDone");
      dragEvent.consume();
    });

    centerPane_.setOnDragEntered((DragEvent dragEvent) -> {
      //System.out.println("setOnDragEntered");
      String formatName = dragEvent.getDragboard().getString();
      if(formatMap_.containsKey(formatName)){
        //centerPane_.setStyle("-fx-background-color: #D9D9D9;");
        centerPane_.setOpacity(0.3);
      }
      //centerPane.setBlendMode(BlendMode.DIFFERENCE);
      dragEvent.consume();
    });

    centerPane_.setOnDragExited((DragEvent dragEvent) -> {
      //System.out.println("setOnDragExited");
      //centerPane_.setStyle("-fx-background-color: #F5F9FA;");
      centerPane_.setOpacity(1);
      //centerPane.setBlendMode(null);
      dragEvent.consume();
    });

    centerPane_.setOnDragOver((DragEvent dragEvent) -> {
      //System.out.println("setOnDragOver");
      dragEvent.acceptTransferModes(TransferMode.MOVE);
      dragEvent.consume();
    });

    centerPane_.setOnDragDropped((DragEvent dragEvent) -> {
      //System.out.println("setOnDragDropped");
      String formatName = dragEvent.getDragboard().getString();
      if(formatMap_.containsKey(formatName)){
        isEditable_ = false;
        if(!centerPane_.getTabs().isEmpty()){
          centerPane_.getTabs().clear();
        }
        Form formFormatCopy = (Form)deepClone(formatMap_.get(formatName).format);
        ruleName_ = "Policy rule " + ruleNameCounter_; // update default rule name
        globalCenterTab_ = generateTab(formFormatCopy.identifier.dispalyName,ruleName_,formFormatCopy);
        centerPane_.getTabs().add(globalCenterTab_);
        dragEvent.setDropCompleted(true);
        dragEvent.consume();
      }
    });

    //certificateListView
    certificateListView_.setOnDragDetected((MouseEvent event) -> {
      //System.out.println("setOnDragDetected");
      Dragboard dragBoard = certificateListView_.startDragAndDrop(TransferMode.MOVE);
      ClipboardContent content = new ClipboardContent();
      Certificate selectedItem = (Certificate)certificateListView_.getSelectionModel().getSelectedItem();
      content.putString(selectedItem.certificate.identifier.dispalyName);
      dragBoard.setContent(content);
      event.consume();
    });

    certificateListView_.setOnDragDone((DragEvent dragEvent) -> {
      //System.out.println("setOnDragDone Certificate");
      dragEvent.consume();
    });
  }

  /**
   This method returns a ScrollPane which contains a form pane, a text field for a rule name and a button for submitting the form.
   @param ruleName  the rule name for the trust policy
   @param form form drag from the format library
   @return ScrollPane
   */
  public ScrollPane createScrollFormPane(String ruleName, Form form){
    // Create a Scroll pane
    ScrollPane sp = new ScrollPane();
    TranslationFormat2Tpl TL = new TranslationFormat2Tpl();
    // create a form pane
    FormPaneContent formPaneContent = createForm(form);
    // TextField for trust policy rule name
    TextField ruleNameField = new TextField(ruleName);
    ruleNameField.setPrefHeight(30);
    formPaneContent.claimPane.add(ruleNameField, 0, formPaneContent.attributeCounter+1);
    // A button for add policy(if isEditable_ is false) or update policy(if isEditable_ is true)
    if(isEditable_ == false){
      ruleNameField.setEditable(true);
      // Add Submit Button
      Button addPolicyButton = new Button("Add policy");
      addPolicyButton.setPrefHeight(30);
      addPolicyButton.setDefaultButton(true);
      addPolicyButton.setPrefWidth(100);
      formPaneContent.claimPane.add(addPolicyButton, 1, formPaneContent.attributeCounter+1);
      GridPane.setHalignment(addPolicyButton, HPos.RIGHT);
      GridPane.setMargin(addPolicyButton, new Insets(20, 0,20,0));
      //handing button event
      addPolicyButton.setOnAction((ActionEvent event) -> {
        Form f = parserFormInput(form, formPaneContent.textFieldList);
        if(f!=null){
          ruleNameCounter_++;
          String tpl = TL.translationToplevel(f);
          TrustPolicy trustpolicy = new TrustPolicy(f,tpl,ruleNameField.getText());
          trustpolicys_.add(trustpolicy);
          trustPolicyList_.add(trustpolicy);
          globalCenterTab_.getTabPane().getTabs().remove(globalCenterTab_);
        }else{
          showAlert(Alert.AlertType.ERROR, formPaneContent.claimPane.getScene().getWindow(), "Form Error!", "Invalid input");
        }
      });
    }else{
      ruleNameField.setEditable(false);
      ruleNameField.setStyle("-fx-background-color: #D9D9D9;");
      // Add Update Button
      Button editPolicyButton = new Button("Update");
      editPolicyButton.setPrefHeight(30);
      editPolicyButton.setDefaultButton(true);
      editPolicyButton.setPrefWidth(100);
      formPaneContent.claimPane.add(editPolicyButton, 1, formPaneContent.attributeCounter+1);
      GridPane.setHalignment(editPolicyButton, HPos.RIGHT);
      GridPane.setMargin(editPolicyButton, new Insets(20, 0,20,0));
      //handing button event
      editPolicyButton.setOnAction((ActionEvent event) -> {
        Form f = parserFormInput(form, formPaneContent.textFieldList);
        if(f!=null){
          selectedPolicy_.tpl = TL.translationToplevel(f);
          globalCenterTab_.getTabPane().getTabs().remove(globalCenterTab_);
        }else{
          showAlert(Alert.AlertType.ERROR, formPaneContent.claimPane.getScene().getWindow(), "Form Error!", "Invalid input");
        }
      });
    }
    sp.setContent(formPaneContent.claimPane);
    return sp;
  }

  /**
   This method creates a form pane
   @param form
   @return FormPaneContent which contains the total numbers of attributes of form, form pane, and a list of its values.
   */
  public FormPaneContent createForm(Form form){
    // Instantiate a new Grid Pane
    GridPane gridPane = new GridPane();
    // Position the pane at the center of the screen, both vertically and horizontally
    gridPane.setAlignment(Pos.CENTER);
    // Set a padding of 20px on each side
    gridPane.setPadding(new Insets(20, 20, 20, 20));
    // Set the horizontal gap between columns
    gridPane.setHgap(10);
    // Set the vertical gap between rows
    gridPane.setVgap(10);
    gridPane.setStyle("-fx-background-color: #D9D9D9;");

    // Add Header
    Label headerLabel = new Label(form.identifier.dispalyName);
    headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
    gridPane.add(headerLabel, 0,0,2,1);
    GridPane.setHalignment(headerLabel, HPos.CENTER);
    GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

    ArrayList<Object> textFieldList = new ArrayList<>();
    int attributeCounter = 0;
    boolean isSignaturalEditable = true;
    for(AttributeValuePair attribute : form.attributes){
      attributeCounter ++;
      // Add Name Label
      Label nameLabel = new Label(attribute.attributeNamePair.displayname);
      gridPane.add(nameLabel, 0,attributeCounter);
      // Add Name Text Field
      if(attribute.value instanceof Form){
        FormPaneContent formPaneContent = createForm((Form)attribute.value);
        gridPane.add(formPaneContent.claimPane, 1,attributeCounter);
        textFieldList.add(formPaneContent.textFieldList);
      }else if(attribute.value instanceof AddableField){
        final int tempCounter = attributeCounter;
        TextField addableField = new TextField();
        addableField.setPrefHeight(30);
        addableField.setEditable(false);
        textFieldList.add(addableField);
        addableField.setStyle("-fx-background-color: #e6eeff;");
        gridPane.add(addableField, 1,attributeCounter);
        //handing drag and drop event (e.g. drag a certificate then drop it in addableField)
        addableField.setOnDragEntered((DragEvent dragEvent) -> {
          //System.out.println("setOnDragEntered Certificate");
          String certificateName = dragEvent.getDragboard().getString();
          if(certificateMap_.containsKey(certificateName)){
            //addableField.setBlendMode(BlendMode.DIFFERENCE);
            addableField.setOpacity(0.5);
            dragEvent.consume();
          }
        });

        addableField.setOnDragExited((DragEvent dragEvent) -> {
          //System.out.println("setOnDragExited Certificate");
          //addableField.setBlendMode(null);
          addableField.setOpacity(1);
          dragEvent.consume();
        });

        addableField.setOnDragOver((DragEvent dragEvent) -> {
          //System.out.println("setOnDragOver Certificate");
          dragEvent.acceptTransferModes(TransferMode.MOVE);
          dragEvent.consume();
        });

        addableField.setOnDragDropped((DragEvent dragEvent) -> {
          //System.out.println("setOnDragDropped Certificate");
          String certificateName = dragEvent.getDragboard().getString();
          if(certificateMap_.containsKey(certificateName)){
            Certificate cert = certificateMap_.get(certificateName);
            Certificate certCopy = (Certificate)deepClone(cert);
            attribute.value = certCopy.certificate;
            FormPaneContent trustListFormPaneClaim = createForm(certCopy.certificate);
            gridPane.getChildren().remove(addableField);
            gridPane.add(trustListFormPaneClaim.claimPane, 1, tempCounter);
            int addableFieldIndex = textFieldList.indexOf(addableField);
            textFieldList.remove(addableField);
            textFieldList.add(addableFieldIndex,trustListFormPaneClaim.textFieldList);
            dragEvent.setDropCompleted(true);
            dragEvent.consume();
          }
        });
      }else if(attribute.value instanceof ClaimTrustList){   // the value of trustList is a special case
        TrustListPane trustListPane = createClaimPane((ClaimTrustList)(attribute.value));
        gridPane.add(trustListPane.claimPane, 1,attributeCounter);
        textFieldList.add(trustListPane.trustListContent);
      }else{ // just normal TextFields
        TextField nameField;
        if(attribute.value instanceof Trustscheme){
          nameField = new TextField("[" + attribute.value.toString()+ "]");
        }else if(attribute.value instanceof TrustschemeX){
          nameField = new TextField("=[" + attribute.value.toString()+ "]");
        }else{
          nameField = new TextField(attribute.value.toString());
        }
        nameField.setPrefHeight(30);
        gridPane.add(nameField, 1,attributeCounter);
        textFieldList.add(nameField);
      }
    }
    return new FormPaneContent(attributeCounter, gridPane, textFieldList);
  }

  /**
   This method creates a pane for the value of trustList
   @param trustList
   @return TrustListPane
   */
  public TrustListPane createClaimPane(ClaimTrustList trustList){
    TrustListPane trustListPane = new TrustListPane();
    TrustListContent trustListContent = new TrustListContent();
    GridPane gridPane_trustList = new GridPane();
    gridPane_trustList.setAlignment(Pos.CENTER);
    gridPane_trustList.setHgap(10);
    gridPane_trustList.setVgap(10);

    TextField nameField;
    if(trustList.trustListValue instanceof Blank){
      nameField = new TextField();
    }else if(trustList.trustListValue instanceof Trustscheme){
      nameField = new TextField("[" + ((Trustscheme)(trustList.trustListValue)).value+ "]");
    }else if(trustList.trustListValue instanceof TrustschemeX){
      nameField = new TextField("= [" + ((TrustschemeX)(trustList.trustListValue)).value + "]");
    }else{
      nameField = new TextField(((Variable)(trustList.trustListValue)).variable);
    }
    nameField.setPrefHeight(30);
    gridPane_trustList.add(nameField, 0,0);
    trustListContent.textField = nameField;
    if(trustList.form == null){
      ComboBox certificateComboBox = new ComboBox();
      certificateComboBox.getItems().add("No Claim");
      HashMap<String,Form> certificateMap = new HashMap<>();

      for(Form certificate : trustList.trustListEntry){
        certificateComboBox.getItems().add(certificate.identifier.dispalyName);
        certificateMap.put(certificate.identifier.dispalyName, certificate);
      }
      certificateComboBox.setValue("Claim");
      certificateComboBox.setEditable(false);
      certificateComboBox.setPrefSize(85, 30);
      gridPane_trustList.add(certificateComboBox, 1,0);
      certificateComboBox.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
          String certificate = certificateComboBox.getValue().toString();
          if(!certificate.equals("No Claim")){
            Form claimForm = certificateMap.get(certificate);
            FormPaneContent trustListFormPane = createForm(claimForm);
            gridPane_trustList.getChildren().remove(certificateComboBox);
            gridPane_trustList.add(trustListFormPane.claimPane, 1,0);
            trustList.form = claimForm;
            trustListContent.textFieldList = trustListFormPane.textFieldList;
          }
        }
      });
    }else{
      FormPaneContent trustListFormPaneClaim = createForm(trustList.form);
      gridPane_trustList.add(trustListFormPaneClaim.claimPane, 1,0);
      trustListContent.textFieldList = trustListFormPaneClaim.textFieldList;
    }
    trustListPane.claimPane = gridPane_trustList;
    trustListPane.trustListContent = trustListContent;
    return trustListPane;
  }

  public boolean parsesAsValue(String text){
    return Pattern.compile("[a-z][a-zA-Z0-9_]*").matcher(text).matches() ||
        Pattern.compile("'[a-zA-Z][a-zA-Z0-9_]*'").matcher(text).matches();
  }

  /**
   This method parses input form
   @param form
   @param textFieldList
   @return a form that contains user input
   */
  public Form parserFormInput(Form form, ArrayList<Object> textFieldList){
    int indexCounter = 0;
    for(Object inputText : textFieldList){
      // if the input value is a text
      if(inputText instanceof TextField){
        String text = ((TextField)inputText).getText();
        if(!text.isEmpty()){ // if the input value is not empty
          if(Pattern.compile("[A-Z][a-zA-Z0-9_]*").matcher(text).matches()){
            form.attributes.get(indexCounter).value = new Variable(text);
          }else if(parsesAsValue(text)){
            form.attributes.get(indexCounter).value = new Value(text);
          //}else if(Pattern.compile("[0-9.]+").matcher(text).matches()){
          //  form.attributes.get(indexCounter).value = new Value(text);
          }else if(Pattern.compile("[<>=]=?([ ]*)?[0-9.]+").matcher(text).matches()) {
            String comp = text.replaceAll("[\\.0-9]", "");
            String number = text.replaceAll("[^\\.0-9]", "");
            int integer = Integer.parseInt(number);
            form.attributes.get(indexCounter).value = new CompValue(comp, new Int(integer));
          }else if(Pattern.compile("[1-9][0-9]*").matcher(text).matches()){
            int integer = Integer.parseInt(text);
            form.attributes.get(indexCounter).value = new Int(integer);
//          }else if(Pattern.compile("[a-zA-Z0-9_.@ ]+").matcher(text).matches()){ // for normal text, need to fix the translation to TPL
//            //form.attributes.get(indexCounter).value = new Value(text.substring(1, text.length()-1).toLowerCase().replaceAll("\\s+",""));
//            form.attributes.get(indexCounter).value = new Value(text);
          }else if(Pattern.compile("\\[[a-zA-Z0-9_.]+\\]").matcher(text).matches()){ // notation "[...]"
            String innerText = text.substring(text.indexOf("[") + 1, text.indexOf("]"));
            if(parsesAsValue(innerText)){
              form.attributes.get(indexCounter).value = new Trustscheme(innerText);
            } else {
              return null;
            }
          }else if(Pattern.compile("=([ ]*)?\\[[a-zA-Z0-9_.]+\\]").matcher(text).matches()){ // notation "=[...]"
            String innerText = text.substring(text.indexOf("[") + 1, text.indexOf("]"));
            if(parsesAsValue(innerText)){
              form.attributes.get(indexCounter).value = new TrustschemeX(innerText);
            } else {
              return null;
            }
          }else{
            return null;
          }
        }else{
          if(form.attributes.get(indexCounter).value instanceof AddableField){
            form.attributes.get(indexCounter).value = new AddableField();
          }else{
            form.attributes.get(indexCounter).value = new Blank();
          }
        }
        // if the input value is the value of attribute trust_list
      }else if(inputText instanceof TrustListContent){
        String text = ((TrustListContent) inputText).textField.getText();
        if(!text.isEmpty()){ // if the value of trust_list is not empty
          if(Pattern.compile("\\[[a-zA-Z0-9_.]+\\]").matcher(text).matches()){ // notation "[...]"
            Trustscheme trustscheme = new Trustscheme(text.substring(text.indexOf("[") + 1, text.indexOf("]")));
            ArrayList<Object> trustListEntryTextFieldList = (((TrustListContent) inputText)).textFieldList;
            ((ClaimTrustList)(form.attributes.get(indexCounter).value)).trustListValue = trustscheme;
            if(((ClaimTrustList)(form.attributes.get(indexCounter).value)).form != null){
              Form claimForm = parserFormInput(((ClaimTrustList)(form.attributes.get(indexCounter).value)).form,trustListEntryTextFieldList);
              if(claimForm != null){
                ((ClaimTrustList)(form.attributes.get(indexCounter).value)).form = claimForm;
              }else {
                return null;
              }
            }
          }else if(Pattern.compile("=([ ]*)?\\[[a-zA-Z0-9_.]+\\]").matcher(text).matches()){ // notation "=[...]"
            TrustschemeX trustschemeX = new TrustschemeX(text.substring(text.indexOf("[") + 1, text.indexOf("]")));
            ArrayList<Object> trustListEntryTextFieldList = (((TrustListContent) inputText)).textFieldList;
            ((ClaimTrustList)(form.attributes.get(indexCounter).value)).trustListValue = trustschemeX;
            // if the trust_list claim for a trust list entry, where the trust list entry is a separate form
            if(((ClaimTrustList)(form.attributes.get(indexCounter).value)).form != null){
              Form claimForm = parserFormInput(((ClaimTrustList)(form.attributes.get(indexCounter).value)).form,trustListEntryTextFieldList);
              if(claimForm != null){
                ((ClaimTrustList)(form.attributes.get(indexCounter).value)).form = claimForm;
              }else {
                return null;
              }
            }
          }else{
            return null;
          }
        }else{
          ((ClaimTrustList)(form.attributes.get(indexCounter).value)).trustListValue = new Blank();
        }
      }else { // if input value is a subform
        ArrayList<Object> subTextFieldList = (ArrayList<Object>)inputText;
        Form subForm = parserFormInput((Form)form.attributes.get(indexCounter).value,subTextFieldList);
        if(subForm != null){
          form.attributes.get(indexCounter).value = subForm;
        }else{
          return null;
        }
      }
      indexCounter++;
    }
    return form;
  }

  private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
    Alert alert = new Alert(alertType);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.initOwner(owner);
    alert.show();
  }

  private void writeTrustPolicyToFile(File file, String tpl){
    BufferedWriter bw = null;
    FileWriter fw = null;
    try {
      try (PrintWriter writer = new PrintWriter(file)) {
        writer.print("");
      }
      // true = append file
      fw = new FileWriter(file.getAbsoluteFile(), true);
      bw = new BufferedWriter(fw);
      bw.write(tpl);
    } catch (IOException e) {
      //e.printStackTrace();
    } finally {
      try {
        if (bw != null)
          bw.close();
        if (fw != null)
          fw.close();
      } catch (IOException ex) {
        //ex.printStackTrace();
      }
    }
  }

  public void writeGTPLpolicyToFile(String filePath, ArrayList<TrustPolicy> trustpolicyList){
    try {
      File file = new File(filePath);
      try (PrintWriter writer = new PrintWriter(file)) {
        writer.print("");
      }
      FileOutputStream f = new FileOutputStream(file);
      ObjectOutputStream o = new ObjectOutputStream(f);
      // Write objects to file
      o.writeObject(trustpolicyList);
      o.close();
      f.close();
    }catch (FileNotFoundException e) {
      System.out.println("File not found");
    }catch (IOException e) {
      System.out.println("Error initializing stream");
    }
  }

  public ArrayList<TrustPolicy> readGTPLpolicyFromFile(File file){
    ArrayList<TrustPolicy> trustPolicys = new ArrayList<>();
    try {
      if(file.exists() && file.length() != 0) {
        try(FileInputStream fi = new FileInputStream(file); ObjectInputStream oi = new ObjectInputStream(fi)) {
          // read objects to file
          trustPolicys = (ArrayList<TrustPolicy>)oi.readObject();
        }
      }
    }catch(FileNotFoundException e) {
      System.out.println("File not found");
    }catch(IOException e) {
      System.out.println("Error initializing stream");
    }catch(ClassNotFoundException e) {}
    return trustPolicys;
  }

  public static Object deepClone(Object object){
    try {
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      ObjectOutputStream oos = new ObjectOutputStream(baos);
      oos.writeObject(object);
      ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
      return ois.readObject();
    }
    catch (IOException | ClassNotFoundException e) {
      return null;
    }
  }

  private Tab generateTab(String name, TextArea text){
    Tab result = new Tab(name);
    BorderPane content = new BorderPane();
    content.setCenter(text);
    result.setContent(content);
    return result;
  }

  private Tab generateTab(String name, ListView listView){
    Tab result = new Tab(name);
    BorderPane content = new BorderPane();
    content.setCenter(listView);
    result.setContent(content);
    return result;
  }

  private Tab generateTab(String tabName,String ruleName, Form form){
    Tab result = new Tab(tabName);
    ScrollPane scrollPane = createScrollFormPane(ruleName, form);
    result.setContent(scrollPane);
    return result;
  }
}
