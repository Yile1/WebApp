var app1 = new Vue({
    el: '#app1',
    data:{
        student:{
            ID:"",
            name:"",
            deptName:"",
            totCred:""
        },
        courses: [],
        show: false
    },

    methods: {
        //改为ES6写法
        courseSearch(){
            axios.get("http://localhost:8080/WebApp/studentServlet", {
                params:{
                    solve: 1,
                    ID: this.$refs.inputVal1.value
                }
            }).then(resp =>{
                //console.log(resp);
                if (resp.data != null) {
                    this.student = resp.data;
                }else{
                    this.student = "";
                    //this.student.deptName = this.student.ID = this.student.name = this.student.totCred = "";
                    this.show = true;
                }
            }).catch(function (error){
                console.log(error);
            })
            axios.get("http://localhost:8080/WebApp/courseServlet", {
                params:{
                    solve: 1,
                    ID: this.$refs.inputVal1.value
                }
            }).then(resp =>{
                //已经是对象，不是JSON字符串了
                //var myData = JSON.parse(resp.data);
                if(resp.data != null) {
                    this.courses = resp.data;
                    this.show = true;
                }else{
                    this.show = true;
                }
                //console.log(resp);
            }).catch(function (error){
                console.log(error);
            })
        }
    }
})

var app2 = new Vue({
    el: '#app2',
    data:{
        courses: [],
        show : false
    },

    methods: {
        //改为ES6写法
        courseSearch(){
            axios.get("http://localhost:8080/WebApp/courseServlet", {
                params:{
                    solve: 2,
                    keyWord: this.$refs.inputVal2.value
                }
            }).then(resp =>{
                //已经是对象，不是JSON字符串了
                //var myData = JSON.parse(resp.data);
                if(resp.data != null) {
                    this.courses = resp.data;
                    this.show = true;
                }else{
                    this.show = true;
                }
            }).catch(function (error){
                console.log(error);
            })
        }
    }
})

var app3 = new Vue({
    el: '#app3',
    data:{
        students: [],
        show: false
    },

    methods: {
        //改为ES6写法
        findFailStudent(){
            axios.get("http://localhost:8080/WebApp/studentServlet", {
                params:{
                    solve:3,
                    failNum: this.$refs.inputVal3.value
                }
            }).then(resp => {
                //console.log(resp);
                if (resp.data != null) {
                    this.students = resp.data;
                    this.show = true;
                }else{
                    //this.student.deptName = this.student.ID = this.student.name = this.student.totCred = "";
                    this.show = true;
                }
            }).catch(function (error){
                console.log(error);
            })
        }
    }
})

var app4 = new Vue({
    el:"#app4",
    data:{
        deptNames: [],
        selected:""
    },
    methods:{
        insertStu(){
            axios.get("http://localhost:8080/WebApp/insertServlet", {
                params:{
                    personType:"student",
                    ID:this.$refs.inputID.value,
                    name:this.$refs.inputName.value,
                    deptName:this.selected
                }
            }).then(resp =>{
                //console.log(resp);
                if (resp.data == "1"){
                    this.$refs.result1.innerHTML = "添加成功";
                }else {
                    this.$refs.result1.innerHTML = resp.data;
                }
            }).catch(function (error){
                console.log(error);
            })
        },

        listDept(){
            axios.get("http://localhost:8080/WebApp/deptServlet", {
                params:{
                }
            }).then(resp => {
                this.deptNames = resp.data;
            }).catch(function (error){
                console.log(error);
            })
        }
    }
})

var app5 = new Vue({
    el:"#app5",
    data:{
        deptNames: [],
        selected:""
    },
    methods:{
        insertInstructor(){
            axios.get("http://localhost:8080/WebApp/insertServlet", {
                params:{
                    personType:"instructor",
                    ID:this.$refs.inputInstructorID.value,
                    name:this.$refs.inputInstructorName.value,
                    deptName:this.selected
                }
            }).then(resp =>{
                //console.log(resp);
                if (resp.data == "1"){
                    this.$refs.result2.innerHTML = "添加成功";
                }else {
                    this.$refs.result2.innerHTML = resp.data;
                }
            }).catch(function (error){
                console.log(error);
            })
        },
        listDept(){
            axios.get("http://localhost:8080/WebApp/deptServlet", {
                params:{
                }
            }).then(resp => {
                this.deptNames = resp.data;
            }).catch(function (error){
                console.log(error);
            })
        }
    }
})

var app6 = new Vue({
    el: '#createDropDown',
    data:{
        lists: [],
        show: false
    },

    methods: {
        //改为ES6写法
        sqlSearch(){
            axios.get("http://localhost:8080/WebApp/sqlServlet", {
                params:{
                    sql: this.$refs.inputSql.value
                }
            }).then(resp => {
                //console.log(resp);
                if (resp.data != null) {
                    this.lists = resp.data;
                    this.show = true;
                }else{
                    //this.student.deptName = this.student.ID = this.student.name = this.student.totCred = "";
                    this.show = true;
                }
            }).catch(function (error){
                console.log(error);
            })
        }
    }
})