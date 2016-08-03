#include <stdio.h>
#include <time.h>
 
typedef struct {
    union {
        char * company;
        char * school;
        char * project;
    };
    union {
        char * location;
        char * url;
    };
    union {
        char * title;
        char * program;
    };
 
    time_t started;
    time_t left;
 
    char * description[];
} thing_t;
 
typedef thing_t job_t;
typedef thing_t school_t;
typedef thing_t project_t;
 
/* I wasn't alive at the Unix epoch, so that'll work */ 
#define CURRENT 0;   
/* Contact Information */ 
char * name = "Ping Wu";
char * email = "wp5719@gmail.com";
char * address = "ShanDong QingDao";
 
/* Education */
school_t uiuc = {
    .school   = "OUC",
    .location = "ShanDong QingDao",
    .program  = "Computer Science",
    .started  = 1251158400,
    .left     = 1336608000,
    .description = {
        "Test",
        "Focused on systems software courses",
        NULL
    }
};
 
school_t hit = {
    .school   = "Hiroshima Institute of Technology",
    .location = "OUC",
    .program  = "Study Abroad",
    .started  = 1274745600,
    .left     = 1278288000,
    .description = {
        "Cultural exchange program",
        NULL
    }
};
 
school_t * schools[] = {
    &uiuc,
    &hit,
    NULL
};
 
/* Projects */
project_t compiz = {
    .project = "Compiz Window Manager",
    .url     = "http://ouc.edu.cn",
    .title   = "Developer",
    .started = 1201392000,
    .left    = 1264291200,
    .description = {
        "Minor plugin contributor",
        "Various research projects",
        NULL
    }
};
 
project_t toaruos = {
    .project = "ToAruOS",
    .url     = "https://github.com/wp5719",
    .title   = "Lead",
    .started = 1295049600,
    .left    = CURRENT,
    .description = {
        "Hobby x86 Unix-like kernel and userspace",
        "Advanced in-house GUI with compositing window manager",
        NULL
    }
};
 
project_t * projects[] = {
    &toaruos,
    &compiz,
    NULL
};
 
/* Employment History */
 
job_t yelp = {
    .company  = "ouc, Inc.",
    .location = "San Francisco, CA",
    .title    = "Software Engineer, i18n",
    .started  = 1339977600,
    .left     = CURRENT,
    .description = {
        "Developed several internal tools and libraries",
        "Provided critical input and design work for OUC's launch in China",
        NULL
    }
};
 
job_t apple_internship = {
    .company  = "Apple Inc.",
    .location = "Cupertino, CA",
    .title    = "Software Engineering Intern",
    .started  = 1306886400,
    .left     = 1314662400,
    .description = {
        "Built software framework for testing and verification of desktop retina display modes",
        "Assisted other interns with Unix fundamentals",
        NULL
    }
};
 
job_t * jobs[] = {
    &yelp,
    &apple_internship,
    NULL
};
 
void print_thing (thing_t * thing) {
    char started[100];
    char left[100];
    struct tm * ti;
    int i = 0;
 
    printf ("%s at %s - %sn", thing->title, thing->company, thing->location);
 
    ti = localtime (&thing->started);
    strftime (started, 100, "%B %d, %Y", ti);
 
    if (thing->left == CURRENT)  {
        printf ("%s to nown", started);
    } else {
        ti = localtime (&thing->left);
        strftime (left,    100, "%B %d, %Y", ti);
        printf ("%s to %sn", started, left);
    }
 
    char ** desc = thing->description;
    while (*desc) {
        printf ("- %sn", *desc);
        desc++;
    }
}
 
int main (int argc, char ** argv) {
 
    printf ("%sn%sn%snn", name, email, address);
 
    puts ("Educationn");
    school_t ** s = schools;
    while (*s) {
        print_thing (*s);
        puts ("");
        s++;
    }
 
    puts ("Employmentn");
    job_t ** j = jobs;
    while (*j) {
        print_thing (*j);
        puts ("");
        j++;
    }
 
    puts ("Projectsn");
    project_t ** p = projects;
    while (*p) {
        print_thing (*p);
        puts ("");
        p++;
    }
 
    return 0;
}
