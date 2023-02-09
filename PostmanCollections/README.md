# Importing and exporting data

Postman can import and export Postman data, including collections, environments, data dumps, and globals. Postman can also import non-Postman data in the form of API schemas to help you consolidate your API development workflow.

## Contents

* [Importing data into Postman](#importing-data-into-postman)

    * [Importing Postman data](#importing-postman-data)

* [Exporting Postman data](#exporting-postman-data)

    * [Exporting collections](#exporting-collections)

    * [Exporting environments](#exporting-environments)

    * [Exporting data dumps](#exporting-data-dumps)

## Importing data into Postman

You can import collections or your API specifications directly into Postman.

To import your data into Postman, select **Import** in upper left:

![Import UI](https://assets.postman.com/postman-docs/import-export-import-ui-v9-6.jpg)

You can import your data from files, folders, links, raw text, or code repositories.

### Importing Postman data

You can import Postman data you exported earlier, including collections, environments, data dumps, and globals.

1. Select **Import** in the left navigation menu.
2. Select your file or folder, input your link, paste your raw text, or [import from GitHub](#importing-via-github-repositories).
   Postman will automatically recognize Postman data, confirming the name, format, and what the file will import as.
   ![Import collection and environment](https://assets.postman.com/postman-docs/import-export-github-files-confirm.jpg)
3. Select the files you want to import.
4. Select **Import** to bring your data into Postman.

## Exporting Postman data

You can export your Postman data, including collections, environments, data dumps, and globals, as JSON files. You can import these files back into any Postman instance, or use them with [Newman](/docs/running-collections/using-newman-cli/command-line-integration-with-newman/), Postman's command-line collection runner.

### Exporting collections

1. Select the more actions icon <img alt="More actions icon" src="https://assets.postman.com/postman-docs/icon-more-actions-v9.jpg#icon" width="16px"> next to the collection, then select **Export**.

   <img alt="Export collection" src="https://assets.postman.com/postman-docs/export-collection-v9.1.jpg" width="350px" />

1. Select the format you'd like your collection to export as.

   > Learn more about Postman's [collection formats](https://blog.postman.com/travelogue-of-postman-collection-format-v2/).
1. Select **Export** to download your newly generated JSON file.

### Exporting environments

You can also export your environments from Postman.

1. Select the **Environments** tab from the left navigation menu.
1. Select an environment to export.
1. In the main work area, select the more actions icon <img alt="More actions icon" src="https://assets.postman.com/postman-docs/icon-more-actions-v9.jpg#icon" width="16px">, then select **Export** to download your newly generated JSON file.

### Exporting data dumps

You can export a data dump of all your collections, environments, globals, and header presets in Postman.
