package test;

public class MockAnnotations {
//Part 5 step 1
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private StudentDataObject studentDataObject;

    @Mock
    private InstructorDataObject instructorDataObject;

    @Mock
    private ClassDataObject classDataObject;

    @InjectMocks
    private ClientBusinessObjectImpl clientBusinessObjectImpl;

//Part 5 step 2

    @Test
    public void testStudentsByClass() {
        // Given
        Student studentJM = new Student(“Joy Ma”, “Spanish);
        Student student JH = new Student(“Julio Hernandez”, “Algebra”);
        Student student JJ = new Student(“Jenny Jones”, “Calculus”);
        List<Student> allStudents = Arrays.asList(studentJM, studentJH, studentJJ);

        given(studentDataObject.getAllStudents()).willReturn(allStudents);

        // When
        List<String> mathStudents = clientBusinessObjectImpl.getAllStudentsBySubject(“math”);

        // Then
        assertThat(mathStudents.size(), is(2));
        assertThat(mathStudents, hasItems(studentJJ, student JH);
    }


//Part 5 Step 3
@Test
public void testMarkInactive() {

    // Given
    Class geometry = new Class(“Geometry”, “Summer 2022);
    Class envSci = new Class(“Environmental Science”, “Fall 2022”);
    Class compLit = new Class(“Comparative Literature”, “Spring 2023”);
    List<Class> allClasses = Arrays.asList(geometry, envSci, compLit);

    given(classDataObject.getAllClasses()).willReturn(allClasses);

    // When
    clientBusinessObjectImpl.markCurrentClassesInactive();

    // Then
    verify(classDataObject).markInactive(geometry);

    verify(classDataObject, Mockito.never()).markInactive(envSci);

    verify(classDataObject, Mockito.never()).markInactive(compLit);

    verify(classDataObject, Mockito.times(1)).markInactive(geometry);
    // atLeastOnce, atLeast

}

//Part 5 Step 4



    @Captor
    ArgumentCaptor<Class> classArgumentCaptor;
    @Test
    public void testMarkInactive_argumentCaptor() {
        // Given
        Class geometry = new Class(“Geometry”, “Summer 2022);
        Class envSci = new Class(“Environmental Science”, “Fall 2022”);
        Class compLit = new Class(“Comparative Literature”, “Spring 2023”);
        List<Class> allClasses = Arrays.asList(geometry, envSci, compLit);

        given(classDataObject.getAllClasses()).willReturn(allClasses);

        // When
        clientBusinessObjectImpl.markCurrentClassesInactive();

        // Then
        verify(classDataObject).markInactive(classArgumentCaptor.capture());

        assertEquals(geometry, classArgumentCaptor.getValue());
    }

    //Part 5 Step 5

    @Test
    public void testGetClassesByInstructor_WithClasses() {

        int instructorId = 123;
        InstructorDataObject instructorDataObject = new InstructorDataObject();


        List<Class> classes = instructorDataObject.getClassesByInstructor(instructorId);


        assertNotNull(classes);
        assertFalse(classes.isEmpty());

    }

    @Test
    public void testGetStudentsInClass_WithStudents() {
        // Arrange
        int classId = 789;
        ClassDataObject classDataObject = new ClassDataObject();


        List<Student> students = classDataObject.getStudentsInClass(classId);


        assertNotNull(students);
        assertFalse(students.isEmpty());

    }



}
