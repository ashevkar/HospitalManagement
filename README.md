# 🏥 ClinicCore: Innovative Role-Driven Healthcare Platform

## 📌 Summary
I created a hospital management system that organizes all the important details about hospitals, doctors, patients, and appointments into one system. This system lets patients connect with many hospitals and doctors, and it lets hospitals connect with many patients too. Each doctor works at one specific hospital, and doctors and patients can make, change, or cancel their appointments easily.

When users first visit the system, they see a simple homepage with a navigation bar that helps them find different sections like **"About Us," "Doctors,"** and **"Departments."** There's also a 🔑 **login button** that users must click to enter their username and password. If they forget to fill these in, the system will alert them to complete these fields.

After logging in, the system shows different things depending on who's using it:
- 👨‍⚕️ **Patients** can look at and change their own information and handle their appointments.
- 🏥 **Hospital staff** can see a list of all the patients at their hospital and add new ones if needed.
- 👩‍⚕️ **Doctors** can see their appointments and adjust them as needed.
- 👨‍💼 **Admins** can see everything, including all the details about patients and which hospitals they visit. They can also look at reports showing how many patients each hospital has.

---

## 🎨 Design of the Hospital Management System
The system starts with a **simple and clear homepage**. There's a 🧭 **navigation bar** at the top with buttons that take you to different parts of the page when you click on them. There's also a **login button** at the top right. If someone tries to log in without entering their username or password, a ⚠️ message will pop up reminding them to fill in those fields.

Once logged in:
- 🏥 **Patients** go to a welcome page and then to their own page where they can check and update their information and manage their appointments.
- 🏩 **Hospital staff** log in and go to a page that shows all the patients at their hospital, and they can also add new patients.
- 👩‍⚕️ **Doctors** log in and get to a page where they can **set up new appointments or change existing ones.**

This design makes it easy for everyone to use the system and helps hospitals and doctors take good care of their patients. 🏥💙

---

## ⚙️ Requirements (Installation, Compile, Runtime, Database, etc.)
### 📥 Steps to Install/Download
1. **Install Java Development Kit (JDK) ☕**
   - Download OpenJDK version 17.0.11+9 for Mac from Adoptium.
   - Install it using the PKG file or by typing:  
     ```bash
     brew install openjdk
     ```

2. **Set Up Environment Variables 🌍**
   - In your macOS terminal, type:
     ```bash
     export JAVA_HOME=$(/usr/libexec/java_home -v 17)
     export PATH=${JAVA_HOME}/bin:${PATH}
     ```
   - Verify by typing:
     ```bash
     java -version
     javac -version
     ```

3. **Install and Set Up an IDE 🖥️**
   - Download and install **Apache NetBeans 21** from the NetBeans website.
   - Let NetBeans install necessary plugins and set up Maven indexes on first launch.

4. **Install and Set Up Payara Server 🚀**
   - Download **Payara Server** from the Payara website.
   - Extract files to a **folder without spaces** in its path.
   - Set up Payara Server in NetBeans.

5. **Install and Set Up MySQL 🗄️**
   - Download **MySQL Community Server 8.0** for macOS.
   - Choose **Custom Setup** and install both MySQL Server and MySQL Workbench.
   - Set a root password.
   - Alternatively, install MySQL using Homebrew:
     ```bash
     brew install mysql
     ```

6. **Set Up MySQL Workbench 🛠️**
   - Open **MySQL Workbench** and connect using the root user.
   - Create a new database schema called `itmd4515` and a new user with full access.

7. **Configure NetBeans to Connect to MySQL 🏗️**
   - Set up NetBeans to connect to the MySQL database you just created.

8. **Testing and Verification ✅**
   - Confirm JDK installation:
     ```bash
     java -version
     ```
   - Verify MySQL is working by running a test query in **MySQL Workbench**.

9. **Dependencies 📦** (Add to `pom.xml`):
   - `jakarta.jakartaee-api` version `${jakartaee}`
   - `mysql-connector-j` version `8.0.33`
   - `junit-jupiter-engine` version `5.10.1`
   - `org.eclipse.persistence.jpa` version `4.0.2`
   - `hibernate-validator` version `8.0.1.Final`
   - `expressly` version `5.0.0`
   - `hibernate-validator-cdi` version `8.0.1.Final`

10. **Run the Project ▶️**
    - Start the **Payara Server**, clean the project data, and then launch the project.

---

## 📸 Screenshots
*Check out the visuals of the system below!*

### 🏠 Home Page
![Home Page](https://github.com/itmd4515/itmd4515-s24-fp-ashevkar/assets/152341739/cd8f3e89-80d2-4d7a-bedd-02ac5383e44f)

![Home Page 2](https://github.com/itmd4515/itmd4515-s24-fp-ashevkar/assets/152341739/9c50542c-ff62-4b84-838b-5db673ef76b6)

### 🔑 Login Validation
![Login Validation](https://github.com/itmd4515/itmd4515-s24-fp-ashevkar/assets/152341739/cfee45e1-152c-4741-b16e-95822ec0d455)

### 🏥 Patient Portal
![Patient Welcome](https://github.com/itmd4515/itmd4515-s24-fp-ashevkar/assets/152341739/a469e9c7-5ab1-4382-afd8-f306d42f6c59)
![Patient Info](https://github.com/itmd4515/itmd4515-s24-fp-ashevkar/assets/152341739/61b1e5d2-6b02-4e67-afb6-7235bdd4bdfd)

### 📝 Patient Profile Management
![Patient View](https://github.com/itmd4515/itmd4515-s24-fp-ashevkar/assets/152341739/60715af4-d639-4e56-a330-3ef9845180e2)
![Patient Edit](https://github.com/itmd4515/itmd4515-s24-fp-ashevkar/assets/152341739/4c577de6-df83-496b-9f56-e1935992118a)

### 📅 Appointment Management
![Patient Schedule](https://github.com/itmd4515/itmd4515-s24-fp-ashevkar/assets/152341739/822d773f-8968-4199-be98-025dda47f92c)
![Appointment Confirmation](https://github.com/itmd4515/itmd4515-s24-fp-ashevkar/assets/152341739/84597878-78f6-46f2-885c-9d9722f5a3ee)

### 👨‍⚕️ Doctor Portal
![Doctor Page](https://github.com/itmd4515/itmd4515-s24-fp-ashevkar/assets/152341739/91a3ab67-4b68-41e7-82fa-70431e279043)

### 🏩 Hospital Management
![Hospital Page](https://github.com/itmd4515/itmd4515-s24-fp-ashevkar/assets/152341739/b700df17-baad-41a2-826c-a871cceec414)

### 🏢 Admin Dashboard
![Admin Dashboard](https://github.com/itmd4515/itmd4515-s24-fp-ashevkar/assets/152341739/769ab348-63af-4fc5-a01f-0d0887ef47dc)

---

## 🔐 Login Credentials
| Role       | Username | Password |
|------------|----------|----------|
| 🏥 Patient | `patient1` | `patient1` |
| 👨‍⚕️ Doctor | `doctor1` | `doctor1` |
| 👨‍💼 Admin | `admin` | `admin` |
| 🏩 Hospital | `hospital1` | `hospital1` |

---

## 🔍 Development Insights
🚧 **Challenges Faced:**
1. **Admin Role Creation Issue ⚠️**
   - I aimed to establish an admin role with the capability to create new users. However, I encountered persistent errors when trying to add usernames and passwords. Despite several days of debugging, the issue remains unresolved.

2. **Appointment Deletion Bug 🛑**
   - Appointments are removed from the **database**, but these changes do not reflect on the **webpage**.

3. **PrimeFaces & JSF Component Library Integration 🚀**
   - I attempted to integrate PrimeFaces, but numerous errors arose, and my debugging efforts were unsuccessful.

---

✨ *Thank you for checking out my project!* 🚀
