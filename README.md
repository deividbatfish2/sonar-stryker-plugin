# Sonar Stryker Mutator Plugin
This project aims create a plugin to integrate [Stryker-Mutator]([https://stryker-mutator.io) and [SonarQube](https://www.sonarqube.org).

## Build
To build the project, clone the repository and run this command:

`mvn clean package`

This generates a `.jar` file of the plugin in "__target__" folder.

## Usage
To use it, copy the `.jar` to sonar's extensions folder.

After this, restart de sonar server.

After restart, create a new sonar quality profile, we recomend to copy the recommended sonar profile.

![Copy the sonar profile](/docs/img/sonar/copy_sonar_profile.png)

And inform a new name

![Name of new profile](/docs/img/sonar/input_name_new_profile.png)

In the new profile select __Activate More__

![Activate More](/docs/img/sonar/activate_more.png)

The name of all rules of stryker starts with __Stryker__. Activate all.

![Select Rules](/docs/img/sonar/select_rules.png)

Set the new profile as __Default__

![Set as Default](/docs/img/sonar/set_as_default.png)

In your project, in the sonar configuration, add the property `'sonar.javascript.stryker.path': '<<path to report json of stryker>>'`

After this, the new analyzes will consider the new rules. The issues will be shown in the __Issues__ pannel.

![Issues Panel](/docs/img/sonar/issues_panel.png)

Selecting the issue, the bug is showing in class file.

![Issues in class file](/docs/img/sonar/issue_in_class_file.png)

Select __why is this an issue?__ to view the documentation.

![Why is this an issue](/docs/img/sonar/why_is_this_an_issue.png)