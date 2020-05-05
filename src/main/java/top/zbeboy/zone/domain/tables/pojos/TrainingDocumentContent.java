/*
 * This file is generated by jOOQ.
 */
package top.zbeboy.zone.domain.tables.pojos;


import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@Generated(
        value = {
                "http://www.jooq.org",
                "jOOQ version:3.12.4"
        },
        comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class TrainingDocumentContent implements Serializable {

    private static final long serialVersionUID = -1523675381;

    private String trainingDocumentId;
    private String trainingDocumentContent;

    public TrainingDocumentContent() {
    }

    public TrainingDocumentContent(TrainingDocumentContent value) {
        this.trainingDocumentId = value.trainingDocumentId;
        this.trainingDocumentContent = value.trainingDocumentContent;
    }

    public TrainingDocumentContent(
            String trainingDocumentId,
            String trainingDocumentContent
    ) {
        this.trainingDocumentId = trainingDocumentId;
        this.trainingDocumentContent = trainingDocumentContent;
    }

    @NotNull
    @Size(max = 64)
    public String getTrainingDocumentId() {
        return this.trainingDocumentId;
    }

    public void setTrainingDocumentId(String trainingDocumentId) {
        this.trainingDocumentId = trainingDocumentId;
    }

    @NotNull
    public String getTrainingDocumentContent() {
        return this.trainingDocumentContent;
    }

    public void setTrainingDocumentContent(String trainingDocumentContent) {
        this.trainingDocumentContent = trainingDocumentContent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TrainingDocumentContent (");

        sb.append(trainingDocumentId);
        sb.append(", ").append(trainingDocumentContent);

        sb.append(")");
        return sb.toString();
    }
}
