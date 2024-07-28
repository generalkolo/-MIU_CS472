String.prototype.filter = function(bannedWords) {
    return this.split(' ')
               .filter(word => !bannedWords.includes(word))
               .join(' ');
};

Array.prototype.bubbleSort = function() {
    let len = this.length;
    for (let i = 0; i < len; i++) {
        for (let j = 0; j < len - 1 - i; j++) {
            if (this[j] > this[j + 1]) {
                // Swap elements
                [this[j], this[j + 1]] = [this[j + 1], this[j]];
            }
        }
    }
    return this;
};

function Person(name) {
    this.name = name;
}

function Teacher(name) {
    Person.call(this, name);
}

Teacher.prototype = Object.create(Person.prototype);
Teacher.prototype.constructor = Teacher;


Teacher.prototype.teach = function(subject) {
    console.log(`${this.name} is now teaching ${subject}`);
};

const personProto = {
    initialize: function(name) {
        this.name = name;
    }
};

const teacherProto = Object.create(personProto);
teacherProto.teach = function(subject) {
    console.log(`${this.name} is now teaching ${subject}`);
};

function createTeacher(name) {
    const teacher = Object.create(teacherProto);
    teacher.initialize(name);
    return teacher;
}


function PersonWithAgeAndName(name, age) {
    this.name = name;
    this.age = age;
}

PersonWithAgeAndName.prototype.greeting = function() {
    console.log(`Greetings, my name is ${this.name} and I am ${this.age} years old.`);
};

PersonWithAgeAndName.prototype.salute = function() {
    console.log("Good morning!, and in case I don't see you, good afternoon, good evening and good night!");
};

function Student(name, age, major) {
    PersonWithAgeAndName.call(this, name, age);
    this.major = major;
}

Student.prototype = Object.create(PersonWithAgeAndName.prototype);
Student.prototype.constructor = Student;

Student.prototype.greeting = function() {
    console.log(`Hey, my name is ${this.name} and I am studying ${this.major}.`);
};

function Professor(name, age, department) {
    PersonWithAgeAndName.call(this, name, age);
    this.department = department;
}

Professor.prototype = Object.create(PersonWithAgeAndName.prototype);
Professor.prototype.constructor = Professor;

Professor.prototype.greeting = function() {
    console.log(`Good day, my name is ${this.name} and I am in the ${this.department} department.`);
};

let student = new Student('Alice', 20, 'Computer Science');
student.greeting();
student.salute();  


let professor = new Professor('Dr. Smith', 45, 'Physics');
professor.greeting();
professor.salute(); 

const personWithNameAndAgeProto = {
    initialize: function(name, age) {
        this.name = name;
        this.age = age;
    },
    greeting: function() {
        console.log(`Greetings, my name is ${this.name} and I am ${this.age} years old.`);
    },
    salute: function() {
        console.log("Good morning!, and in case I don't see you, good afternoon, good evening and good night!");
    }
};

const studentProto = Object.create(personWithNameAndAgeProto);
studentProto.initialize = function(name, age, major) {
    personWithNameAndAgeProto.initialize.call(this, name, age);
    this.major = major;
};
studentProto.greeting = function() {
    console.log(`Hey, my name is ${this.name} and I am studying ${this.major}.`);
};

const professorProto = Object.create(personWithNameAndAgeProto);
professorProto.initialize = function(name, age, department) {
    personWithNameAndAgeProto.initialize.call(this, name, age);
    this.department = department;
};
professorProto.greeting = function() {
    console.log(`Good day, my name is ${this.name} and I am in the ${this.department} department.`);
};

function createStudent(name, age, major) {
    const student = Object.create(studentProto);
    student.initialize(name, age, major);
    return student;
}

function createProfessor(name, age, department) {
    const professor = Object.create(professorProto);
    professor.initialize(name, age, department);
    return professor;
}

let student2 = createStudent('Bob', 22, 'Mathematics');
student2.greeting();
student2.salute();

let professor2 = createProfessor('Dr. Johnson', 50, 'Chemistry');
professor2.greeting(); 
professor2.salute();


console.log("This house is not nice!".filter(['not']));

console.log([6, 4, 0, 3, -2, 1].bubbleSort());

let teacher1 = new Teacher('John');
teacher1.teach('Mathematics');

let teacher2 = createTeacher('Jane');
teacher2.teach('Physics');






