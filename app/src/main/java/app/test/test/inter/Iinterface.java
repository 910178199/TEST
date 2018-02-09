package app.test.test.inter;

import java.lang.annotation.Inherited;

/**
 * Created by think on 2018-01-31.
 */

public class Iinterface {

    @Inherited
    public @interface InheritedAnnotation {

    }

    public @interface ClassPreamble {
        String author();

        String date();

        int currentRevision() default 1;

        String lastModified() default "N/A";

        String lastModifiedBy() default "N/A";

        // Note use of array
        String[] reviewers();
    }


}
