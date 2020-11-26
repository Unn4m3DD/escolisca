class GraphTest {
    void a() {
        b();
    }

    void b() {
        c();
    }

    void c() {
        c();
        d();
    }

    void d() {
        c();
    }

    void e() {
        f();
    }

    void f() {
        e();
        b();
    }

    void g() {
    }
}