---
layout: page
title: User Guide
---

<!--
@@author {sivayogasubramanian}-reused
Reused from https://github.com/AY2021S1-CS2103T-W16-3/tp/pull/179/commits/aec461182c194c9ca2c67d7c407fcabb376191ff
-->
<div class="toc-no-bullet-points">
  * Table of Contents
  {:toc}
</div>

--------------------------------------------------------------------------------------------------------------------

## 1. Introduction

### 1.1 About BobTheBistroBoss

BobTheBistroBoss (BTBB) is a **desktop application that aims to help home-based F&B businesses, by keeping track of logistics as well as
providing valuable data visualizations, via a user-friendly command-line interface (CLI).** Keeping track of
information from inventory to order records for delivery can be a hassle if you are a one-man show. That's why, our
application centralizes all data in one place, and even comes with a Graphical User Interface (GUI) to easily view and
manoeuvre through client and order details. If you are looking for an easy solution to manage your business, give BTBB a try!

--------------------------------------------------------------------------------------------------------------------

## 2. Quick start

### 2.1 Installation

1. Ensure you have Java version 11 or above installed in your Computer. You may install the latest version of Java [here](https://www.oracle.com/java/technologies/downloads/).

2. Download the jar file of the application.

3. Copy the file to an empty folder. This will be the _home folder_ for BTBB.

4. Double-click the file to start the application.

5. Type any command in the command box and press the Enter key to execute it.<br>
   Some example commands you can try:
   * **`help`** : Opens the help window
   * **`list-c`** : Lists all clients.

6. Refer to the [Features](#4-features) below for details of each command.

### 2.2 Layout
The user interface of BobTheBistroBoss is divided into 2 tabs.

#### 2.2.1 Home Tab
Displays [orders](#33-order), [client bookmarks](#31-client-bookmarks) and [recipe bookmarks](#34-recipe-bookmarks).

![Home tab](images/product-screenshots/general/HomeTab.png){:.image}

Fig 1. Home tab
{:.caption}

#### 2.2.2 Inventory & Statistics Tab
Displays [inventory](#32-inventory) and [statistics](#35-statistics).

![Inventory & Statistics tab](images/product-screenshots/general/BarChart.png)

Fig 2. Inventory & Statistics tab
{:.caption}

--------------------------------------------------------------------------------------------------------------------

## 3. Overview of Features

### 3.1 Client (Bookmarks)

* Client bookmarks are client information that can be copied to an order's client details when adding an order.
* Client bookmarks are considered duplicates when they have the same phone number.
* 'Client Bookmarks' may also be referred to as 'Clients' for simplicity.
* Client bookmarks are sorted in ascending alphabetical order of client name.
  Uppercase letters appear before lowercase letters.

### 3.2 Inventory

* The inventory displays a list of ingredients whose quantities can be tracked.
* Ingredients are considered duplicates when they have the same name and unit.
* The matching of names and units are case insensitive.
* Ingredients in the inventory are sorted by ascending alphabetical order of ingredient name.
  Uppercase letters appear before lowercase letters.

### 3.3 Order

* Orders contain client details, recipe details, deadline, quantity, price and a completion status.
* Orders are considered duplicates when they have the same client details, recipe details, deadline and price.
* The matching of details are case insensitive where applicable.
* Orders are sorted by completion status, then deadline. Uncompleted orders appear before completed orders.
  Within each group of uncompleted and completed orders, orders with earlier deadlines are higher in the list.

### 3.4 Recipe (Bookmarks)

* Recipe bookmarks contain details like recipe name, ingredients and price that can be copied to an order's recipe details when adding an order.
* Recipe bookmarks are considered duplicates when they have the same name, ingredients and price.
* The matching of details are case insensitive where applicable.
* `Recipe Bookmarks` may also be referred to as `Recipes` for simplicity.
* Recipe bookmarks are sorted by ascending alphabetical order of recipe name.
  Uppercase letters appear before lowercase letters.

### 3.5 Statistics

* 3 types of statistics are shown:
  * Revenue per month for the past 12 months.
  * Top 10 clients who made the highest number of orders.
  * Top 10 recipes that appear in the highest number of orders.

--------------------------------------------------------------------------------------------------------------------

## 4. Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add-o cn/CLIENT_NAME`, `CLIENT_NAME` is a parameter which can be used as `add-o cn/John Doe`.

* Items in square brackets are optional.<br>
  e.g. `cn/CLIENT_NAME [ri/INGREDIENT_NAME-QUANTITY-UNIT, ...]` can be used as `cn/John Doe ri/Garlic-1-whole` or as
  `cn/John Doe`.

* Parameters can be in any order.<br>
  e.g. if the command specifies `cn/CLIENT_NAME cp/CLIENT_PHONE`, `cp/CLIENT_PHONE cn/CLIENT_NAME` is also acceptable.

* If a parameter is expected only once in the command, but you specified it multiple times, only the last occurrence of the parameter will be taken.<br>
  e.g. if you specify `cp/12341234 cp/56785678`, only `cp/56785678` will be taken.

* Extraneous parameters for commands that do not take in parameters (such as `help`, and `list-c`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

* The format of all date fields is `dd-MM-yyyy`.
  e.g. 21-10-1998 is 21 October 1998.

* The format of all deadline fields is `dd-MM-yyyy HHmm`. e.g. 21-10-1998 1830 is 21 October 1998 6.30pm.
</div>

### 4.1 Viewing help : `help`

Displays all commands and their format.

Format: `help`

### 4.2 Switching Tabs: `tab`

Switches to the specified tab.

Format: `tab INDEX`

* Switches to the tab corresponding to the specified INDEX. INDEX must be either 1 or 2.
  * Index 1 corresponds to the Home tab.
  * Index 2 corresponds to the Inventory tab.

Example:

* `tab 1` switches to the Home tab.

### 4.3 Client

![AddOrderCommandFull](images/labelled-cards/ClientCardLabelled.png)

Fig 3. Parts of a client
{:.caption}

#### 4.3.1 Adding a client: `add-c`

Adds a client to the application.

Format: `add-c cn/NAME cp/PHONE ce/EMAIL ca/ADDRESS`

<div markdown="block" class="alert alert-primary">

**:bookmark: Note:**<br>

* <code>cp/PHONE</code> refers to a client's phone number and is unique to a client. Each phone number in the system must belong to exactly one client.
* Please refer to the examples below.

</div>

**Examples:**
* `add-c cn/Alex Yeoh cp/89653101 ce/alexyeoh@gmail.com ca/Choa Chu Kang St 62 Blk 123 #12-34` Adds a client with the following attributes:
  * Name: Alex Yeoh
  * Phone number: 89653101
  * Email: 'alexyeoh@gmail.com'
  * Address: 'Choa Chu Kang St 62 Blk 123 #12-34'

#### 4.3.2 Deleting a client: `delete-c`

Deletes a client from the application.

Format: `delete-c INDEX`

**Examples:**
* `delete-c 1` Deletes the client at index 1 in the client list currently shown.

#### 4.3.3 Editing clients: `edit-c`

Edits an existing client in the application.

Format: `edit-c INDEX [cn/NAME] [cp/PHONE] [ce/EMAIL] [ca/ADDRESS]`

<div markdown="block" class="alert alert-primary">

**:bookmark: Note:**<br>

* `INDEX` allows you to choose which client to edit by specifying its position in the currently displayed client list.

* `[cn/NAME], [cp/PHONE], [ce/EMAIL], [ca/ADDRESS]` allows you to specify the client information to update. None of
  them are mandatory, but at least one must be specified.

</div>

**Examples:**
*  `edit-c 3 cn/Amy ce/Amy1234@gmail.com` Edits the third client in the currently shown client list by changing the name to 'Amy' and the email to 'Amy1234@gmail.com'.

#### 4.3.4 Finding clients by keywords: `find-c`

Finds client(s) whose attribute(s) match the keyword(s).

Format: `find-c [cn/NAME] [cp/PHONE] [ce/EMAIL] [ca/ADDRESS]`

<div markdown="block" class="alert alert-primary">

**:bookmark: Note:**<br>

* The search is case-insensitive.

* There must be 1 or more search arguments.

* Multiple search keywords can be specified for each field. <br>
  e.g. <code>find-c cn/Alex Brian</code>

* Partial search will be allowed. <br>
  e.g. <code>find-c cn/Al</code> can show orders for clients with names like Alice and Alex.

* It will find clients that match at least one keyword, for each prefix.

* Please refer to the examples below. <br>

</div>

**Examples:**
* `find-c cn/al` Find clients with names containing 'al'. E.g. **Al**ex, Abig**al**e.
* `find-c cp/22312` Find clients with phone numbers containing 22312. E.g. 9**22312**11.
* `find-c cn/Al Ice cp/9123 923111` Find clients whose name and phone contains at least 1 of the
  keywords for each prefix. Any clients with the following details will be matched:
  * **Al**ex **9123**1100
  * Bern**ice** 98**9123**45
  * **Al**ex **923111**97
  * Bern**ice** 91**923111**

#### 4.3.5 Listing all clients: `list-c`

Lists all clients in the application.

Format: `list-c`

### 4.4 Ingredient

![AddOrderCommandFull](images/labelled-cards/IngredientCardLabelled.png)

Fig 4. Parts of an ingredient
{:.caption}

#### 4.4.1 Adding an ingredient: `add-i`

Adds an ingredient to the application.

Format: `add-i in/NAME iq/QUANTITY iu/UNIT`

<div markdown="block" class="alert alert-primary">

**:bookmark: Note:**<br>

* The application does not allow duplicate ingredients to be added.
* An ingredient is considered a duplicate if it has the same `NAME` and `UNIT` as an existing ingredient in the application.
* The matching of `NAME` and `UNIT` are case insensitive.
* `QUANTITY` must be positive, and the largest possible input is 40000.
* Please refer to the examples below.

</div>

**Examples:**
* `add-i in/White Rice iq/4000 iu/g` adds 4000g of White Rice to the Inventory.

#### 4.4.2 Deleting an ingredient: `delete-i`

Deletes an ingredient from the application.

Format: `delete-i INDEX`

**Examples:**
* `delete-i 1` Deletes the ingredient at index 1 in the ingredient list currently shown.

#### 4.4.3 Editing ingredients: `edit-i`

Edits an existing ingredient in the application.

Format: `edit-i INDEX [in/NAME] [iq/QUANTITY] [iu/UNIT]`

<div markdown="block" class="alert alert-primary">

**:bookmark: Note:**<br>

* `INDEX` allows you to choose which ingredient to edit by specifying its position in the currently displayed ingredient list.

* `[in/NAME] [iq/QUANTITY] [iu/UNIT]` allows you to specify the ingredient information to update. None of
  them are mandatory, but at least one must be specified.

</div>

**Examples:**
*  `edit-i 2 in/Apple iu/whole` Edits the second ingredient in currently shown ingredient list by changing the
   name to 'Apple' and the unit to 'whole'.

#### 4.4.4 Finding ingredients by keywords: `find-i`

Finds ingredient(s) whose attribute(s) match the keyword(s).

Format: `find-i [in/NAME] [iq/QUANTITY] [iqf/QUANTITY_FROM] [iqt/QUANTITY_TO] [iu/UNIT]`

<div markdown="block" class="alert alert-primary">

**:bookmark: Note:**<br>

* The search is case-insensitive.
* There must be 1 or more search arguments.
* Multiple search keywords can be specified for each field. <br>
  e.g. <code>find-i in/Kiwi Chocolate</code>
* Partial search will be allowed. <br>
  e.g. <code>find-i in/Ap</code> can show ingredients with names like Apple and Apricot.
* Ingredient `QUANTITY`:
  * keywords for `QUANTITY` finds ingredients with a quantity that is equal to any of the given keywords.
  * keywords for `QUANTITY_FROM `and `QUANTITY_TO` finds ingredients with a quantity in the range, inclusive of `QUANTITY_FROM` and `QUANTITY_TO`.
  * If keywords are given for both `QUANTITY` and both `QUANTITY_FROM` and `QUANTITY_TO`, then found ingredients must satisfy all 3 conditions.

* It will find ingredients that match at least one keyword, for each prefix.

* Please refer to the examples below. <br>

</div>

**Examples:**
* `find-i in/co` Find ingredients with names containing 'co'. E.g. **Co**rn, Ba**co**n.
* `find-i iq/20 33` Find ingredients with quantities equal to 20 or 33.
* `find-i in/co eg iqf/7 iqt/19 iu/g` Find ingredients with name and unit containing at least 1 of the keywords for each prefix, and quantity in the specified range.
  These ingredients with the following details will be matched:
  * **Co**rn **7** **g**rams
  * **Eg**g **19** k**g**
  * V**eg**etable Oil **14** **g**

#### 4.4.5 Listing all ingredients: `list-i`

Lists all ingredients in the application.

Format: `list-i`

### 4.5 Order

![AddOrderCommandFull](images/labelled-cards/OrderCardLabelled.png)

Fig 5. Parts of an order
{:.caption}

#### 4.5.1 Adding an order: `add-o`

Adds an order to the application.

Format: `add-o [c/CLIENT_INDEX] [cn/CLIENT_NAME] [cp/CLIENT_PHONE] [ca/CLIENT_ADDRESS] [r/RECIPE_INDEX] [rn/RECIPE_NAME]
[ri/INGREDIENT_NAME-QUANTITY-UNIT, ...] [op/ORDER_PRICE] od/ORDER_DEADLINE [oq/ORDER_QUANTITY]`

<div markdown="block" class="alert alert-primary">

**:bookmark: Note:**<br>

* `od/ORDER_DEADLINE` includes date and time, it must follow the format specified [above](#4-features).

Client details include client name, phone and address, they must be provided in one of these ways:
* If `c/CLIENT_INDEX` is present, client details are copied from the client bookmark at the given index to the order.
* If `cn/`, `cp/` or `ca/` are provided with `c/`, client details are taken from `cn/`, `cp/` or `ca/` instead.
* If `c/` is not present, `cn/`, `cp/` and `ca/` must be provided.

Recipe details include recipe name, ingredients and price. Recipe name and order price must be provided in one of these ways:
* If `r/RECIPE_INDEX` is present, recipe details are copied from the recipe bookmark at the given index to the order.
  `ORDER_PRICE` is calculated by multiplying the copied `RECIPE_PRICE` with `QUANTITY` of the order.
* If `rn/`, `ri/` or `op/` is provided with `r/`, details are taken from `rn/`, `ri/` or `op/` instead.
* If `r/` is not present, `rn/` and `op/` must be provided.

These details are fully optional:
* `oq/ORDER_QUANTITY` is set to 1 by default if not specified.
* `ri/INGREDIENT_NAME-QUANTITY-UNIT, ...` does not need to be specified.

Secondary processes that happen when you add an order:
* For each ingredient in the order, the inventory will find [matching ingredients](#32-inventory) and decrease their quantity.
  The inventory quantity is decreased by the ingredient quantity in the order, multiplied by the order quantity.
  If the ingredient in the order does not exist in the inventory, there is no effect.
* All orders have an uncompleted status upon addition.

* Please refer to the examples below.

</div>

**Examples:**
* `add-o cn/Amy Tang cp/98796844 ca/188 Gul Circle rn/Chicken Rice ri/Rice-2-cups, Chicken-1-half op/5.00 od/12-12-2021
  1800 oq/2`. Adding an order without client index and recipe index.

![AddOrderCommandFull](images/product-screenshots/order/AddOrderCommandFullFocused.png)

Fig 6. Adding an order without client index and recipe index
{:.caption}

* `add-o c/1 rn/Chicken Rice ri/Rice-2-cups, Chicken-1-half op/5.00 od/12-12-2021 1800 oq/2`. Adding an order using a client index.

![AddOrderCommandFull](images/product-screenshots/order/AddOrderCommandWithClientIndexOnlyFocused.png)

Fig 7. Adding an order using a client index
{:.caption}

* `add-o cn/Amy Tang cp/98796844 ca/188 Gul Circle r/3 od/12-12-2021 1800 oq/2`. Adding an order using a recipe index.

![AddOrderCommandFull](images/product-screenshots/order/AddOrderCommandWithRecipeIndexOnlyFocused.png)

Fig 8. Adding an order using a recipe index
{:.caption}

* `add-o c/1 r/3 od/12-12-2021 1800 oq/2`. Adding an order using both client and recipe indexes.

![AddOrderCommandFull](images/product-screenshots/order/AddOrderCommandWithClientAndRecipeIndexFocused.png)

Fig 9. Adding an order using both client and recipe indexes
{:.caption}

#### 4.5.2 Adding an order ingredient: `add-oi`

Adds an ingredient to an order in the application.

Format: `add-oi INDEX in/INGREDIENT_NAME iq/INGREDIENT_QUANTITY iu/INGREDIENT_UNIT`

<div markdown="block" class="alert alert-primary">

**:bookmark: Note:**<br>

* `INDEX` allows you to choose which order to add ingredients to by specifying its position in the currently displayed order list.
* Ingredients that already exist in the order cannot be added again. Instead,
  perform delete order ingredient command first before performing this command again.
* If the ingredient to be added already exists in the inventory (see [here](#32-inventory)), the quantity deducted
  from the inventory will be equivalent to the ingredient quantity in the order
  multiplied by the order quantity.

</div>

**Examples:**
* `add-oi 1 in/Rice iq/400 iu/g` Adds 400 grams of Rice to the ingredients of the first order.

#### 4.5.3 Deleting an order: `delete-o`

Deletes an order from the application.

Format: `delete-o INDEX`

<div markdown="block" class="alert alert-primary">

**:bookmark: Note:**<br>

* `INDEX` allows you to choose which order to delete by specifying its position in the currently displayed order list.
* When an order is deleted from the list, the ingredient quantities are added back to the inventory. However, if the
  order is already marked as done, the ingredient quantities will not be added back.

</div>

**Examples:**
* `delete-o 1` Deletes the order at index 1 in the order list currently shown.

#### 4.5.4 Deleting an order ingredient: `delete-oi`

Deletes an ingredient from an order in the application.

Format: `delete-oi ORDER_INDEX i/INGREDIENT_INDEX`

<div markdown="block" class="alert alert-primary">

**:bookmark: Note:**<br>

* `ORDER_INDEX` allows you to choose which order to delete ingredients from by specifying its position in the currently displayed order list.
* `INGREDIENT_INDEX` allows you to choose which ingredient to delete from the order by specifying its position in the currently displayed order ingredient sub-list.
* When an ingredient is deleted from an order, the ingredient will be added back to the inventory.
  The quantity added to the inventory will be equivalent to the deleted ingredient's quantity
  in the order multiplied by the order quantity.

</div>

**Examples:**
* `delete-oi 1 i/2` Deletes the second ingredient from the ingredient list of
  the first order.

#### 4.5.5 Editing an order: `edit-o`

Edits an order in the application.

Format: `edit-o INDEX [c/CLIENT_INDEX] [cn/CLIENT_NAME] [cp/CLIENT_PHONE] [ca/CLIENT_ADDRESS] [r/RECIPE_INDEX]
[rn/RECIPE_NAME] [op/ORDER_PRICE] [od/ORDER_DEADLINE] [oq/ORDER_QUANTITY]`

<div markdown="block" class="alert alert-primary">

**:bookmark: Note:**<br>

* `INDEX` allows you to choose which order to edit by specifying its position in the currently displayed order list.
* `[c/CLIENT_INDEX], [cn/CLIENT_NAME], [cp/CLIENT_PHONE], [ca/CLIENT_ADDRESS], [r/RECIPE_INDEX], [rn/RECIPE_NAME],
  [op/ORDER_PRICE], [od/DEADLINE], [oq/QUANTITY]` allows you to specify the order information to update. None of
  them are mandatory, but at least one must be specified.
* To edit an order's ingredient list, refer to [4.5.2 Adding an order ingredient](#452-adding-an-order-ingredient-add-oi) and [4.5.4 Deleting an order ingredient](#454-deleting-an-order-ingredient-delete-oi).

</div>

**Examples:**

* `edit-o 1 cn/David` Edits the first order in the list currently shown by changing the client's name to David.
* `edit-o 2 cn/Carol cp/98765432` Edits the second order in the list currently shown by changing the client's name
  to Carol and the client's phone number to 98765432.

#### 4.5.6 Finding orders by keywords: `find-o`

Find order(s) with attribute(s) that contains the keyword(s).

Format: `find-o [cn/CLIENT_NAME] [cp/CLIENT_PHONE] [ca/CLIENT_ADDRESS] [rn/RECIPE_NAME] [od/ORDER_DATE] [of/YES_OR_NO]`

<div markdown="block" class="alert alert-primary">

**:bookmark: Note:**<br>

* The search is case-insensitive.
* There must be 1 or more search arguments.
* Multiple search keywords can be specified for each field. <br>
  e.g. <code>find-o cn/Alex Brian</code>
* Partial search will be allowed. <br>
  e.g. <code>find-o cn/Al</code> can show orders for clients with names like Alice and Alex.
* It will find orders that match at least one keyword, for each prefix.
* `od/ORDER_DATE` represents the order date and time. They must follow the format specified [above](#4-features).
* `of/YES_OR_NO` represents whether the order is completed.

* Please refer to the examples below. <br>

</div>

**Examples:**
* `find-o cn/al` Find orders for clients with names containing 'al'. E.g. **Al**ex, K**al**yn.
* `find-o cp/91234567` Find orders for clients with phone numbers that contain 91234567. E.g. **91234567**, 87**91234567**3421
* `find-o cn/Alex David cp/9123 9231` Find orders for clients whose name and phone contains at least 1 of the
  keywords for each prefix. Any orders with the following client details will be matched:
  * **Alex** **9123**1100
  * **David** 8912**9123**
  * **Alex** 9881**9231**
  * **David** **9231**6612

#### 4.5.7 Listing all orders: `list-o`

Lists all orders in the application.

Format: `list-o`

#### 4.5.8 Marking an order as done: `done-o`

Mark order as done once it has been delivered to the client.

Format: `done-o INDEX`

**Examples:**
* `done-o 1` Marks the order at index 1 in the order list currently shown as done.

#### 4.5.9 Marking an order as undone: `undone-o`

Mark order as undone.

Format: `undone-o INDEX`

**Examples:**
* `undone-o 1` Marks the order at index 1 in the order list currently shown as undone.

### 4.6 Recipe

![AddOrderCommandFull](images/labelled-cards/RecipeCardLabelled.png)

Fig 10. Parts of a recipe
{:.caption}

#### 4.6.1 Adding a recipe: `add-r`

Adds a recipe to the application.

Format: `add-r rn/RECIPE_NAME [ri/INGREDIENT_NAME-QUANTITY_UNIT, ...] rp/RECIPE_PRICE`

<div markdown="block" class="alert alert-primary">

**:bookmark: Note:**<br>

* The application does not allow duplicate recipes to be added.
* A recipe is considered a duplicate if it has the same `RECIPE_NAME`, list of ingredients and `RECIPE_PRICE` as an existing recipe in the application.
* The matching of fields are case insensitive.
* Please refer to the examples below.

</div>

**Examples:**
* `add-r rn/Soup ri/Carrot-2-Stick, Egg-1-Whole rp/2.00` adds a recipe named Soup, with 2 ingredients and a price of $2.00.

#### 4.6.2 Adding a recipe ingredient: `add-ri`

Adds an ingredient to a recipe in the application.

Format: `add-ri INDEX in/INGREDIENT_NAME iq/INGREDIENT_QUANTITY iu/INGREDIENT_UNIT`

<div markdown="block" class="alert alert-primary">

**:bookmark: Note:**<br>

* `INDEX` allows you to choose which recipe to add ingredients to by specifying its position in the currently displayed recipe list.
* Ingredients that already exist in the recipe cannot be added again. Instead,
  perform delete recipe ingredient command first before performing this command again.
* Refer to [3.2 Inventory](#32-inventory) for the definition of a duplicate ingredient.

</div>

**Examples:**
* `add-ri 1 in/Rice iq/400 iu/g` Adds 400 grams of Rice to the ingredients of the first recipe.

#### 4.6.3 Deleting a recipe: `delete-r`

Deletes a recipe from the application.

Format: `delete-r INDEX`

<div markdown="block" class="alert alert-primary">

**:bookmark: Note:**<br>

* `INDEX` allows you to choose which recipe to delete by specifying its position in the currently displayed recipe list.

</div>

**Examples:**
* `delete-r 1` Deletes the recipe at index 1 in the recipe list currently shown.

#### 4.6.4 Deleting a recipe ingredient: `delete-ri`

Deletes an ingredient from a recipe in the application.

Format: `delete-ri RECIPE_INDEX i/INGREDIENT_INDEX`

<div markdown="block" class="alert alert-primary">

**:bookmark: Note:**<br>

* `RECIPE_INDEX` allows you to choose which recipe to delete ingredients from by specifying its position in the currently displayed recipe list.
* `INGREDIENT_INDEX` allows you to choose which ingredient to delete from the recipe by specifying its position in the currently displayed recipe ingredient sub-list.

</div>

**Examples:**
* `delete-ri 1 i/2` Deletes the second ingredient from the ingredient list of
  the first recipe.

#### 4.6.5 Editing a recipe: `edit-r`

Edits an existing recipe in the application.

Format: `edit-r INDEX [rn/RECIPE_NAME] [rp/RECIPE_PRICE]`

<div markdown="block" class="alert alert-primary">

**:bookmark: Note:**<br>

* `INDEX` allows you to choose which recipe to edit by specifying its position in the currently displayed recipe list.

* `[rn/RECIPE_NAME] [rp/RECIPE_PRICE]` allows you to specify the recipe information to update. None of
  them are mandatory, but at least one must be specified.

* To edit a recipe's ingredient list, refer to [4.6.2 Adding a recipe ingredient](#462-adding-a-recipe-ingredient-add-ri) and [4.6.4 Deleting a recipe ingredient](#464-deleting-a-recipe-ingredient-delete-ri).

</div>

**Examples:**
*  `edit-r 2 rn/Burger rp/8` Edits the second recipe in currently shown recipe list by changing the
   recipe name to 'Burger' and the recipe price to $8.00.

#### 4.6.6 Finding recipe by keywords: `find-r`

Find recipe(s) with attribute(s) that contains the keyword(s). <br>
Recipes can only be found using recipe name.

Format: `find-r rn/RECIPE_NAME`

<div markdown="block" class="alert alert-primary">

**:bookmark: Note:**<br>

* The search is case-insensitive.

* `rn/RECIPE_NAME` search field must be present.

* Multiple search keywords can be specified for each field. <br>
  e.g. <code>find-r cr/Chicken rice</code>

* Partial search will be allowed.
  e.g. <code>find-r rn/Ch</code> can show recipes with names like Chicken rice and Cheesecake.

* Please refer to the examples below. <br>

</div>

**Examples:**
* `find-r rn/Chicken rice` Find recipes with a name that contains at least 1 of the
  keywords for each prefix. Any recipes with the following names will be matched:
  * Teriyaki **Chicken**
  * **Chicken** **Rice**
  * Kimchi Fried **Rice**

#### 4.6.7 Listing all recipes: `list-r`

Lists all recipes in the application.

Format: `list-r`

### 4.7 Statistics

#### 4.7.1 Viewing revenue per month for the past 12 months
* Displays a bar chart showing the revenue earned per month for the past 12 months. Revenue is calculated only
  from completed orders
* Values will be displayed when you hover your cursor over each bar.

![Inventory & Statistics tab](images/product-screenshots/general/BarChart.png)

Fig 11. Revenue bar chart
{:.caption}

#### 4.7.2 Viewing top 10 clients
* Displays a pie chart showing the top 10 clients who made the highest number of orders.
* Ties are broken arbitrarily i.e. If there are multiple clients with the same number of orders, 10 random clients
  will be displayed.
* Values will be displayed when you hover your cursor over each wedge.

![Inventory & Statistics tab](images/product-screenshots/general/ClientPieChart.png)
Fig 12. Client pie chart
{:.caption}

#### 4.7.3 Viewing top 10 recipes
* Displays a pie chart showing the top 10 recipes that appear in the highest number of orders.
* Ties are broken arbitrarily i.e. If there are multiple recipes with the same number of orders, 10 random recipes
  will be displayed.
* Values will be displayed when you hover your cursor over each wedge.

![Inventory & Statistics tab](images/product-screenshots/general/RecipePieChart.png)

Fig 13. Recipe pie chart
{:.caption}

### 4.8 Exiting the program: `exit`

Exits the program.

Format: `exit`

### 4.9 Saving the data

BTBB data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### 4.10 Editing the data file

BTBB data are saved as a JSON file. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, BTBB will discard all data and start with an empty data file at the next run.
</div>

--------------------------------------------------------------------------------------------------------------------

## 5. FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the application in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous BTBB home folder.

--------------------------------------------------------------------------------------------------------------------

## 6. Disclaimers

### 6.1 Data
* App starts with seed data if there is no initial data file.
* If a user edits the JSON file with invalid data, the application
  will not show any data on startup.

### 6.2 Format
* For deadlines, 29-12-2021 2400 is considered valid, and it will be
  represented as 30-12-2021 0000 in the application.
* Prices can be an integer value or a floating point value with
  **exactly** 2 decimal places.

### 6.3 Index
* When index is negative, the application displays the `INVALID COMMAND FORMAT` error
  rather than the `index provided is invalid` error as the command format requires users
  to key in a positive number.

### 6.4 Quantities
* If any quantity field in orders is changed in the JSON file, the
  application will not automatically reflect the corresponding changes
  in the inventory.
* If the quantity attribute has been changed in a command such that
  it exceeds the lower bound 0 or the upper bound 40000, they will be
  capped off to the respective bounds. For example, if the quantity has
  been changed to -30, it will be capped off to 0. Likewise, if the
  quantity has been changed to 50000, it will be capped off to 40000.
* Ingredient quantity cannot change beyond the min and max cap.
  (e.g. If the user reaches the upper boundary and tries to increase
  the quantity further by deleting an existing order that uses the
  ingredient, the system will allow the deletion but inventory no
  longer tracks the ingredient properly.)

--------------------------------------------------------------------------------------------------------------------

## 7. Command summary

Action                      | Format and Examples
----------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
**Add client**              | `add-c cn/NAME cp/PHONE ce/EMAIL ca/ADDRESS`
**Delete client**           | `delete-c INDEX`
**Edit client**             | `edit-c INDEX [cn/NAME] [cp/PHONE] [ce/EMAIL] [ca/ADDRESS]`
**Find client**             | `find-c [cn/NAME] [cp/PHONE] [ce/EMAIL] [ca/ADDRESS]`
**List client**             | `list-c`
**Add ingredient**          | `add-i in/INGREDIENT_NAME iq/INGREDIENT_QUANTITY iu/INGREDIENT_UNIT`
**Delete ingredient**       | `delete-i INDEX`
**Edit ingredient**         | `edit-i INDEX [in/NAME] [iq/QUANTITY] [iu/UNIT]`
**Find ingredient**         | `find-i [in/NAME] [iq/QUANTITY] [iqf/QUANTITY_FROM] [iqt/QUANTITY_TO] [iu/UNIT]`
**List ingredient**         | `list-i`
**Add order**               | `add-o [c/CLIENT_INDEX] [cn/CLIENT_NAME] [cp/CLIENT_PHONE] [ca/CLIENT_ADDRESS] [r/RECIPE_INDEX] [rn/RECIPE_NAME] [ri/INGREDIENT_NAME-QUANTITY-UNIT, ...] [op/ORDER_PRICE] od/ORDER_DEADLINE [oq/ORDER_QUANTITY]`
**Add order ingredient**    | `add-oi INDEX in/INGREDIENT_NAME iq/INGREDIENT_QUANTITY iu/INGREDIENT_UNIT`
**Delete order**            | `delete-o INDEX`
**Delete order ingredient** | `delete-oi ORDER_INDEX i/INGREDIENT_INDEX`
**Edit order**              | `edit-o INDEX [c/INDEX] [cn/CLIENT_NAME] [cp/CLIENT_PHONE] [ca/CLIENT_ADDRESS] [rn/RECIPE_NAME] [op/ORDER_PRICE] [od/ORDER_DEADLINE] [oq/QUANTITY]`
**Find order**              | `find-o [cn/CLIENT_NAME] [cp/CLIENT_PHONE] [ca/CLIENT_ADDRESS] [rn/RECIPE_NAME] [od/ORDER_DATE] [of/YES_OR_NO]`
**List order**              | `list-o`
**Mark order as done**      | `done-o INDEX`
**Mark order as undone**    | `undone-o INDEX`
**Add recipe**              | `add-r rn/RECIPE_NAME [ri/INGREDIENT_NAME-QUANTITY_UNIT, ...] rp/RECIPE_PRICE`
**Add recipe ingredient**   | `add-ri INDEX in/INGREDIENT_NAME iq/INGREDIENT_QUANTITY iu/INGREDIENT_UNIT`
**Delete recipe**           | `delete-r INDEX`
**Delete recipe ingredient**| `delete-ri RECIPE_INDEX i/INGREDIENT_INDEX`
**Edit recipe**             | `edit-r INDEX [rn/RECIPE_NAME] [rp/RECIPE_PRICE]`
**Find recipe**             | `find-r rn/RECIPE_NAME`
**List recipe**             | `list-r`
**Help**                    | `help`
**Tab**                     | `tab INDEX`
**Exit**                    | `exit`
